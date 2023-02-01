package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.FidelityLevel;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsReward;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.Manager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/owner")
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerService;

    /***********************************
     ** Owner related CRUD operations **
     **********************************/

    @PostMapping(path = "/add")
    public Owner addOwner(@NonNull @RequestBody Owner owner) {
        return this.ownerService.save(owner);
    }

    @GetMapping(path = "/get/{id}")
    public Owner getOwner(@NonNull @PathVariable("id") Long id) {
        return this.ownerService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Owner> getAll() {
        return this.ownerService.getAll();
    }

    @PutMapping(path = "/update/{id}")
    public Owner update(@NonNull @RequestBody @PathVariable("id") Long id) {
        return this.ownerService.update(this.ownerService.findById(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.ownerService.deleteById(id);
    }

    @DeleteMapping(path = "delete/")
    public void delete(@NonNull @RequestBody Owner owner) {
        this.ownerService.delete(owner);
    }


    /* ***********************************************
     ** Other Operations that the Owner can perform **
     ************************************************/


    /********************* Company related methods  *********************/

    @PostMapping(path = "/addCompany/{ownerId}")
    public Company addCompany(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @RequestBody Company company) {
        return this.ownerService.addCompany(ownerId, company);
    }
    /*
    @PutMapping(path = "/updateCompany/{ownerId}/{companyId}")
    public Company updateCompany(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody Company company) {
        return this.ownerService.updateCompany(ownerId, companyId, company);
    }

    @DeleteMapping(path = "deleteCompany/{ownerId}/{companyId}")
    public void deleteCompany(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId) {
        this.ownerService.deleteCompany(ownerId, companyId);
    }
    */

    /********************* Compaign related methods  *********************/

    @PostMapping(path = "/{ownerId}/getCompanies/{companyId}/addCampaign")
    public Campaign addCampaign(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody Campaign campaign) {
        return this.ownerService.addCampaign(ownerId, companyId, campaign);
    }
    /*
    @PutMapping(path = "/updateCampaign/{ownerId}/{campaignId}")
    public Company updateCampaign(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("campaignId") Long campaignId, @NonNull @RequestBody Campaign campaign) {
        return this.ownerService.updateCampaign(ownerId, campaignId, campaign);
    }

    @DeleteMapping(path = "deleteCampaign/{ownerId}/{companyId}")
    public void deleteCampaign(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId) {
        this.ownerService.deleteCampaign(ownerId, companyId);
    }
    */

    /********************* Manager related methods  *********************/

    @PostMapping(path = "/{ownerId}/getCompanies/{companyId}/addManager")
    public Manager addManager(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody Manager manager) {
        return this.ownerService.addManager(ownerId, companyId, manager);
    }
    /*
    @PutMapping(path = "/updateManager/{ownerId}/{managerId}")
    public Company updateManager(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("managerId") Long managerId, @NonNull @RequestBody Manager manager) {
        return this.ownerService.updateManager(ownerId, managerId, manager);
    }

    @DeleteMapping(path = "deleteManager/{ownerId}/{companyId}")
    public void deleteManager(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId) {
        this.ownerService.deleteManager(ownerId, companyId);
    }
    */

    /********************* Fidelity Program related methods  *********************/

    @PostMapping(path = "/{ownerId}/getCompanies/{fidelityProgramId}/addFidelityProgram")
    public FidelityProgram addFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("fidelityProgramId") Long fidelityProgramId, @NonNull @RequestBody FidelityProgram fidelityProgram) {
        return this.ownerService.addFidelityProgram(ownerId, fidelityProgramId, fidelityProgram);
    }
    /*
    @PutMapping(path = "/updateFidelityProgram/{ownerId}/{fidelityProgramId}")
    public FidelityProgram updateFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("fidelityProgramId") Long fidelityProgramId, @NonNull @RequestBody FidelityProgram fidelityProgram) {
        return this.ownerService.updateFidelityProgram(ownerId, fidelityProgramId, fidelityProgram);
    }

    @DeleteMapping(path = "deleteFidelityProgram/{ownerId}/{fidelityProgramId}")
    public void deleteFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("fidelityProgramId") Long fidelityProgramId) {
        this.ownerService.deleteFidelityProgram(ownerId, fidelityProgramId);
    }
    */

    /********** Points Fidelity Program **********/

    @PostMapping(path = "/{ownerId}/getCompanies/{companyId}/addPointsFidelityProgram")
    public PointsFidelityProgram addPointsFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody PointsFidelityProgram pointsFidelityProgram) {
        return this.ownerService.addPointsFidelityProgram(ownerId, companyId, pointsFidelityProgram);
    }
    /*
    @PutMapping(path = "/updatePointsFidelityProgram/{ownerId}/{pointsFidelityProgramId}")
    public PointsFidelityProgram updatePointsFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("pointsFidelityProgramId") Long pointsFidelityProgramId, @NonNull @RequestBody PointsFidelityProgram manager) {
        return this.ownerService.updatePointsFidelityProgram(ownerId, pointsFidelityProgramId, manager);
    }

    @DeleteMapping(path = "deletePointsFidelityProgram/{ownerId}/{pointsFidelityProgramId}")
    public void deletePointsFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("pointsFidelityProgramId") Long pointsFidelityProgramId) {
        this.ownerService.deletePointsFidelityProgram(ownerId, pointsFidelityProgramId);
    }
    */

    /********** Level Fidelity Program **********/

    @PostMapping(path = "/{ownerId}/getCompanies/{companyId}/addLevelFidelityProgram")
    public LevelFidelityProgram addLevelFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody LevelFidelityProgram levelFidelityProgram) {
        return this.ownerService.addLevelFidelityProgram(ownerId, companyId, levelFidelityProgram);
    }
    /*
    @PutMapping(path = "/updateLevelFidelityProgram/{ownerId}/{levelFidelityProgramId}")
    public LevelFidelityProgram updateLevelFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("levelFidelityProgramId") Long levelFidelityProgramId, @NonNull @RequestBody LevelFidelityProgram levelFidelityProgram) {
        return this.ownerService.updateLevelFidelityProgram(ownerId, levelFidelityProgramId, levelFidelityProgram);
    }

    @DeleteMapping(path = "deleteLevelFidelityProgram/{ownerId}/{levelFidelityProgramId}")
    public void deleteLevelFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("levelFidelityProgramId") Long levelFidelityProgramId) {
        this.ownerService.deleteLevelFidelityProgram(ownerId, levelFidelityProgramId);
    }
    */
    @PostMapping(path = "/{ownerId}/getCompanies/{companyId}/getPointsFidelityProgram/{pointsFidelityProgramId}/addReward")
    public PointsReward addPointsReward(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @PathVariable("pointsFidelityProgramId") Long pointsFidelityProgramId, @NonNull @RequestBody PointsReward pointsReward){
        return this.ownerService.addPointsReward(ownerId,companyId,pointsFidelityProgramId,pointsReward);
    }

    @PostMapping(path = "/{ownerId}/getCompanies/{companyId}/getLevelFidelityProgram/{levelFidelityProgramId}/addLevel")
    public FidelityLevel addFidelityLevel(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @PathVariable("levelFidelityProgramId") Long levelFidelityProgramId, @NonNull @RequestBody FidelityLevel fidelityLevel){
        return this.ownerService.addFidelityLevel(ownerId, companyId, levelFidelityProgramId, fidelityLevel);
    }

}
