package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class FidelityLevelServiceImpl implements GeneralService<FidelityLevel> {
    @Autowired
    private FidelityLevelRepository repository;

    @Override
    public FidelityLevel save(@NonNull FidelityLevel fidelityLevel) {
        if (!repository.findAll().contains(fidelityLevel)) {
            return this.repository.save(fidelityLevel);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Fidelity level already exists");
        }
    }
    @Override
    public FidelityLevel findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelity level not found"));
    }

    @Override
    public Optional<FidelityLevel> get(@NonNull FidelityLevel fidelityLevel) {
        return this.repository.findById(fidelityLevel.getId());
    }
    @Override
    public List<FidelityLevel> getAll() {
        return this.repository.findAll();
    }
    @Override
    public FidelityLevel update(@NonNull FidelityLevel fidelityLevel) {
        return this.repository.save(fidelityLevel);
    }
    @Override
    public FidelityLevel updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }
    @Override
    public void delete(@NonNull FidelityLevel fidelityLevel) {
        this.repository.delete(fidelityLevel);
    }
    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

}
