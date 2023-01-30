package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FidelityLevelService {
    @Autowired
    private FidelityLevelRepository repository;

    public FidelityLevel save(@NonNull FidelityLevel fidelityLevel) {
        if (!repository.findAll().contains(fidelityLevel)) {
            return this.repository.save(fidelityLevel);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Fidelity level already exists");
        }
    }

    public FidelityLevel findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelity level not found"));
    }

    public List<FidelityLevel> getAll() {
        return this.repository.findAll();
    }

    public FidelityLevel update(@NonNull FidelityLevel fidelityLevel) {
        return this.repository.save(fidelityLevel);
    }

    public FidelityLevel updateById(@NonNull Long id) {
        //TODO
        return null;
    }

    public void delete(@NonNull FidelityLevel fidelityLevel) {
        this.repository.delete(fidelityLevel);
    }

    public void delete(@NonNull Long id) {
        this.repository.deleteById(id);
    }

}
