package it.unicam.cs.ids.loyaltyPlatform.service;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.repository.FidelityProgramRepository;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FidelityProgramService {

    @Autowired
    private FidelityProgramRepository repository;

    public FidelityProgram addFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        return this.repository.save(fidelityProgram);
    }

    public Optional<FidelityProgram> getFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        return this.repository.findById(fidelityProgram.getId());
    }

    public FidelityProgram updateFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        return this.repository.updateFidelityProgram(fidelityProgram);
    }

    public void deleteFidelityProgram(@NonNull @NotNull FidelityProgram fidelityProgram) {
        // one of the lines below is to be removed
        this.repository.deleteById(fidelityProgram.getId());
        this.repository.delete(fidelityProgram);
    }

}
