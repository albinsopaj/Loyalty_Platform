package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import jakarta.persistence.Table;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Table(name = "")
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository repository;


    @Override
    public Campaign save(@NotNull Campaign campaign) {
        return this.repository.save(campaign);
    }

    @Override
    public void saveById(@NonNull Long id) {
        //TODO implement
        // repository doesn't provide a ready to use saveById method.
    }

    @Override
    public Campaign update(@NonNull Campaign campaign) {
        Campaign oldCampaign = this.repository.findById(campaign.getId()).orElse(null);

        if (existsById(oldCampaign.getId())) {
            if (oldCampaign.getId().equals(campaign.getId())) {
                return this.repository.save(campaign);
            } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "...");
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inexistent campaign.");
    }

    @Override
    public Campaign updateById(@NonNull Long id) {
        Optional<Campaign> old = this.repository.findById(id);

        if (old.isPresent()) {
            Campaign originalCampaign = old.get();
            return this.repository.save(originalCampaign);
        }
        return null;
    }

    @Override
    public Campaign findById(@NonNull Long id) {
        //one of the lines below should be removed
        //return this.repository.getReferenceById(id);
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found"));
    }

    @Override
    public Optional<Campaign> getById(@NonNull Long id) {
        Optional<Campaign> campaign = this.repository.findById(id);
        if (campaign.isPresent()) {
            return this.repository.findById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found");
        }
    }

    @Override
    public List<Campaign> getAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(@NonNull Campaign campaign) {
        this.repository.delete(campaign);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        if (this.repository.findById(id).isPresent()) {
            this.repository.deleteById(id);
            System.out.println("Campaign deleted successfully");
        } else {
            System.out.println("No such campaign in the database");
        }
    }

    private boolean existsById(@NonNull Long id) {
        return this.repository.existsById(id);
    }

}