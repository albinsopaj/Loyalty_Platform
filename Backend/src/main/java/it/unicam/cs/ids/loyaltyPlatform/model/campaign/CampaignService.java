package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CampaignService {

    void save(Campaign campaign);

    //TODO must be implemented by scratch.
    void saveById(UUID id);

    Campaign update(@NonNull Campaign campaign);

    Campaign findById(@NonNull UUID id);

    Optional<Campaign> getById(UUID id);

    List<Campaign> getAll();

    void delete(Campaign campaign);

    void deleteById(UUID id);

}
