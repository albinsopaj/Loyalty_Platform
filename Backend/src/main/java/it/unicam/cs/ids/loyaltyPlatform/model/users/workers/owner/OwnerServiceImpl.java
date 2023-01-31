package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.campaign.CampaignServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.company.CompanyServiceImpl;
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
        this.repository.delete(owner);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    public Campaign addCampaign(@NonNull Long ownerId, @NonNull Long companyId, @NonNull Campaign campaign){
        if(findById(ownerId).getCompanies().contains(this.companyService.findById(companyId))){
            campaign.setCompany(this.companyService.findById(companyId));
            return this.campaignService.save(campaign);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Company not owned by this owner");
        }
    }
}
