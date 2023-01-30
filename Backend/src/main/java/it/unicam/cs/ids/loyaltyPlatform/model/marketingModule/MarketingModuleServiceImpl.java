package it.unicam.cs.ids.loyaltyPlatform.model.marketingModule;

import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MarketingModuleServiceImpl implements GeneralService<MarketingModule> {

    @Autowired
    private MarketingModuleRepository repository;

    @Override
    public MarketingModule save(@NonNull MarketingModule marketingModule) {
        if(!repository.findAll().contains(marketingModule)){
            return this.repository.save(marketingModule);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Marketing Module already exists");
        }
    }

    @Override
    public MarketingModule findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Marketing Module not found"));
    }

    @Override
    public Optional<MarketingModule> get(@NonNull MarketingModule marketingModule) {
        return this.repository.findById(marketingModule.getId());
    }

    @Override
    public List<MarketingModule> getAll() {
        return this.repository.findAll();
    }

    @Override
    public MarketingModule update(@NonNull MarketingModule marketingModule) {
        return this.repository.save(marketingModule);
    }

    @Override
    public MarketingModule updateById(@NonNull Long id) {
        //TODO
        return null;
    }

    @Override
    public void delete(@NonNull MarketingModule marketingModule) {
        this.repository.delete(marketingModule);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

}
