package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignServiceImpl implements GeneralService<Campaign> {

    @Autowired
    private CampaignRepository repository;

    @Override
    public Campaign save(@NonNull Campaign campaign) {
        if (!this.repository.existsById(campaign.getId())) {
            this.repository.save(campaign);
            return campaign;
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campaign is already present!");
    }

    @Override
    public Campaign findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found"));
    }

    @Override
    public Optional<Campaign> get(@NonNull Campaign campaign) {
        return this.repository.findById(campaign.getId());
    }

    @Override
    public List<Campaign> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Campaign update(@NonNull Campaign campaign) {
        if (this.repository.existsById(campaign.getId())) {
            this.repository.save(campaign);
            return campaign;
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campaign does not exist!");
    }

    @Override
    public Campaign updateById(@NonNull Long id) {
        if (this.repository.existsById(id)) {
            this.repository.save(findById(id));
            return findById(id);
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trying to update non-existing campaign!");
    }

    @Override
    public void delete(@NonNull Campaign campaign) {
        for (Campaign c : this.repository.findAll()) {
            if (this.repository.existsById(c.getId())) {
                this.repository.delete(campaign);
            } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found");
        }
    }

    @Override
    public void deleteById(@NonNull Long id) {
        if (this.repository.findById(id).isPresent()) {
            this.repository.deleteById(id);
            System.out.println("Campaign deleted successfully");
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found");
    }

}