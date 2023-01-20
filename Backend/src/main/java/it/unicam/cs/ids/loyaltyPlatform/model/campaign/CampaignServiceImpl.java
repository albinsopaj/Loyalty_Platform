package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import jakarta.persistence.Table;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Table()
public class CampaignServiceImpl implements CampaignService {

    @Autowired
    private CampaignRepository repository;


    @Override
    public void save(Campaign campaign) {
        this.repository.save(campaign);
    }

    @Override
    public void saveById(UUID id) {
        //TODO implement
        // repository doesn't provide a ready to use saveById method.
    }

    public Campaign update(@NonNull Campaign campaign) {
        Campaign oldCampaign = repository.findById(campaign.getId()).orElse(null);
        if (existById(oldCampaign.getId())) {
            if (oldCampaign.getId().equals(campaign.getId())) {
                return this.repository.save(campaign);
            } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "...");
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Inexistent campaign.");
    }

    public Campaign findById(@NonNull UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found"));
    }

    @Override
    public Optional<Campaign> getById(@NonNull UUID id) {
        return this.repository.findById(id);
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
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

    private boolean existById(@NonNull UUID id) {
        return this.repository.existsById(id);
    }

}