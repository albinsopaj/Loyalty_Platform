package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface CampaignService {

    Campaign save(@NonNull Campaign campaign);

    //TODO must be implemented by scratch.
    void saveById(Long id);

    Campaign update(@NonNull Campaign campaign);

    Campaign updateById(@NonNull Long id);

    Campaign findById(@NonNull Long id);

    Optional<Campaign> getById(@NonNull Long id);

    List<Campaign> getAll();

    void delete(@NonNull Campaign campaign);

    void deleteById(@NonNull Long id);

}
