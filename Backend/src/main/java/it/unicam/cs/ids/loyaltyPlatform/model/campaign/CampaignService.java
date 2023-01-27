package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.NonNull;

import java.util.List;

public interface CampaignService {

    Campaign save(@NonNull Campaign campaign);

    Campaign update(@NonNull Campaign campaign);

    Campaign updateById(@NonNull Long id);

    Campaign findById(@NonNull Long id);

    List<Campaign> getAll();

    void delete(@NonNull Campaign campaign);

    void deleteById(@NonNull Long id);

}
