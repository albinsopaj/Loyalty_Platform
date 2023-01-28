package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class FidelityProgramServiceImpl implements FidelityProgramService {

    @Autowired
    private FidelityProgramRepository repository;


    @Override
    public FidelityProgram saveById(@NonNull Long id) {
        return this.repository.save(this.findById(id));
    }

    @Override
    public FidelityProgram findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelity Program not found"));
    }

    @Override
    public Optional<FidelityProgram> get(@NonNull FidelityProgram fidelityProgram) {
        return this.repository.findById(fidelityProgram.getId());
    }

    @Override
    public List<FidelityProgram> getAll() {
        return this.repository.findAll();
    }

    @Override
    public FidelityProgram update(@NonNull FidelityProgram fidelityProgram) {
        return this.repository.save(fidelityProgram);
    }

    @Override
    public FidelityProgram updateById(@NonNull Long id) {
        return null;
    }

    @Override
    public void delete(@NonNull FidelityProgram fidelityProgram) {
        this.repository.delete(fidelityProgram);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }


}
