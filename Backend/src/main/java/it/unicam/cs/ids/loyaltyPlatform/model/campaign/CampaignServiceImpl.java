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
        if (!repository.findAll().contains(campaign)) {
            return this.repository.save(campaign);
        } else throw new ResponseStatusException(HttpStatus.FOUND, "Campaign already exists");
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
        return this.repository.save(campaign);
    }

    @Override
    public Campaign updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull Campaign campaign) {
        this.repository.delete(campaign);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

}