package it.unicam.cs.ids.loyaltyPlatform.model.marketingModule;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface MarketingModuleService {

    MarketingModule save(@NonNull MarketingModule marketingModule);

    MarketingModule saveById(@NonNull Long id);

    MarketingModule findById(@NonNull Long id);

    Optional<MarketingModule> get(@NonNull MarketingModule marketingModule);

    List<MarketingModule> getAll();

    MarketingModule update(@NonNull MarketingModule marketingModule);

    MarketingModule updateById(@NonNull Long id);

    void delete(@NonNull MarketingModule marketingModule);

    void deleteById(@NonNull Long id);

}
