package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.campaign.CampaignServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.company.CompanyServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.FidelityLevel;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.FidelityLevelServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgramServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgramServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsReward;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsRewardServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.Manager;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.ManagerServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements GeneralService<Owner> {

    @Autowired
    private OwnerRepository repository;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private CampaignServiceImpl campaignService;
    @Autowired
    private ManagerServiceImpl managerService;
    @Autowired
    private PointsFidelityProgramServiceImpl pointsFidelityProgramService;
    @Autowired
    private LevelFidelityProgramServiceImpl levelFidelityProgramService;
    @Autowired
    private FidelityProgramServiceImpl fidelityProgramService;


    /***********************************
     ** Owner related CRUD operations **
     **********************************/

    @Autowired
    private PointsRewardServiceImpl pointsRewardService;

    @Autowired
    private FidelityLevelServiceImpl fidelityLevelService;

    public Owner save(@NonNull Owner owner) {
        if (!repository.findAll().contains(owner)) {
            owner.setCompanies(new ArrayList<>());
            return this.repository.save(owner);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Owner already exists");
        }
    }

    @Override
    public Owner findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));
    }

    @Override
    public Optional<Owner> get(@NonNull Owner owner) {
        return this.repository.findById(owner.getId());
    }

    @Override
    public List<Owner> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Owner update(@NonNull Owner owner) {
        return this.repository.save(owner);
    }

    @Override
    public Owner updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull Owner owner) {
        if (this.repository.existsById(owner.getId())) {
            this.repository.delete(owner);
        } else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User to be deleted is not present!");
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }



    /* ***********************************************
     ** Other Operations that the Owner can perform **
     ************************************************/

    /********************* Company related methods  *********************/

    public Company addCompany(@NonNull Long ownerId, @NonNull Company company) {
        company.setOwner(findById(ownerId));
        return this.companyService.save(company);
    }

    public Company updateCompany(@NonNull Long ownerId, @NonNull Long companyId, @NonNull Company company) {

    }

    public void deleteCompany(@NonNull Long ownerId, @NonNull Long companyId) {

    }


    /********************* Compaign related methods  *********************/

    public Campaign addCampaign(@NonNull Long ownerId, @NonNull Long companyId, @NonNull Campaign campaign) {
        if (findById(ownerId).getCompanies().contains(this.companyService.findById(companyId))) {
            campaign.setCompany(this.companyService.findById(companyId));
            return this.campaignService.save(campaign);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Company not owned by this owner");
        }
    }

    public Company updateCampaign(@NonNull Long ownerId, @NonNull Long campaignId, @NonNull Campaign campaign) {

    }

    public void deleteCampaign(@NonNull Long ownerId, @NonNull Long companyId) {

    }

    /********************* Manager related methods  *********************/

    public Manager addManager(@NonNull Long ownerId, @NonNull Long companyId, @NonNull Manager manager) {
        if (findById(ownerId).getCompanies().contains(this.companyService.findById(companyId))) {
            manager.setCompany(this.companyService.findById(companyId));
            this.companyService.findById(companyId).addManager(manager);
            return this.managerService.save(manager);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Company not owned by this owner");
        }
    }

    public Company updateManager(@NonNull Long ownerId, @NonNull Long managerId, @NonNull Manager manager) {

    }

    public void deleteManager(@NonNull Long ownerId, @NonNull Long companyId) {

    }


    /********************* Fidelity Program related methods  *********************/

    public FidelityProgram addFidelityProgram(@NonNull Long ownerId, @NonNull Long companyId, @NonNull FidelityProgram fidelityProgram) {
        if (findById(ownerId).getCompanies().contains(this.companyService.findById(companyId))) {
            fidelityProgram.setCompany(this.companyService.findById(companyId));
            this.companyService.findById(companyId).addFidelityProgram(fidelityProgram);
            if (fidelityProgram instanceof PointsFidelityProgram pointsFidelityProgram) {
                return this.pointsFidelityProgramService.save(pointsFidelityProgram);
            } else {
                return this.levelFidelityProgramService.save((LevelFidelityProgram) fidelityProgram);
            }
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Company now owned by this owner");
        }
    }

    public FidelityProgram updateFidelityProgram(@NonNull Long ownerId, @NonNull Long fidelityProgramId, @NonNull FidelityProgram fidelityProgram) {

    }

    public void deleteFidelityProgram(@NonNull Long ownerId, @NonNull Long fidelityProgramId) {

    }

    /********** Points Fidelity Program **********/

    public PointsFidelityProgram addPointsFidelityProgram(@NonNull Long ownerId, @NonNull Long companyId, @NonNull PointsFidelityProgram pointsFidelityProgram) {
        if (findById(ownerId).getCompanies().contains(this.companyService.findById(companyId))) {
            pointsFidelityProgram.setCompany(this.companyService.findById(companyId));
            this.companyService.findById(companyId).addFidelityProgram(pointsFidelityProgram);
            return this.pointsFidelityProgramService.save(pointsFidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Company now owned by this owner");
        }
    }

    public PointsFidelityProgram updatePointsFidelityProgram(@NonNull Long ownerId, @NonNull Long pointsFidelityProgramId, @NonNull PointsFidelityProgram manager) {

    }

    public void deletePointsFidelityProgram(@NonNull Long ownerId, @NonNull Long pointsFidelityProgramId) {

    }


    /********** Level Fidelity Program **********/

    public LevelFidelityProgram addLevelFidelityProgram(@NonNull Long ownerId, @NonNull Long companyId, @NonNull LevelFidelityProgram levelFidelityProgram) {
        if (findById(ownerId).getCompanies().contains(this.companyService.findById(companyId))) {
            levelFidelityProgram.setCompany(this.companyService.findById(companyId));
            this.companyService.findById(companyId).addFidelityProgram(levelFidelityProgram);
            return this.levelFidelityProgramService.save(levelFidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Company now owned by this owner");
        }
    }

    public LevelFidelityProgram updateLevelFidelityProgram(@NonNull Long ownerId, @NonNull Long levelFidelityProgramId, @NonNull LevelFidelityProgram levelFidelityProgram) {

    }

    public void deleteLevelFidelityProgram(@NonNull Long ownerId, @NonNull Long levelFidelityProgramId) {

    }

    public Company addCompany(@NonNull Long ownerId, @NonNull Company company){
        company.setOwner(findById(ownerId));
        return this.companyService.save(company);
    }

    public PointsReward addPointsReward(@NonNull Long ownerId, @NonNull Long companyId, @NonNull Long pointsFidelityProgramId, @NonNull PointsReward pointsReward){
        if(findById(ownerId).getCompanies().contains(this.companyService.findById(companyId)) && this.companyService.findById(companyId).getFidelityPrograms().contains(pointsFidelityProgramService.findById(pointsFidelityProgramId))){
            pointsReward.setPointsFidelityProgram(this.pointsFidelityProgramService.findById(pointsFidelityProgramId));
            this.pointsFidelityProgramService.findById(pointsFidelityProgramId).addReward(pointsReward);
            return this.pointsRewardService.save(pointsReward);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Owner doesn't own this company or fidelity program");
        }
    }

    public FidelityLevel addFidelityLevel(@NonNull Long ownerId, @NonNull Long companyId, @NonNull Long levelFidelityProgramId, @NonNull FidelityLevel fidelityLevel){
        if(findById(ownerId).getCompanies().contains(this.companyService.findById(companyId)) && this.companyService.findById(companyId).getFidelityPrograms().contains(levelFidelityProgramService.findById(levelFidelityProgramId))){
            fidelityLevel.setLevelFidelityProgram(this.levelFidelityProgramService.findById(levelFidelityProgramId));
            this.levelFidelityProgramService.findById(levelFidelityProgramId).addFidelityLevel(fidelityLevel);
            return this.fidelityLevelService.save(fidelityLevel);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Owner doesn't own this company or fidelity program");
        }
    }

}
