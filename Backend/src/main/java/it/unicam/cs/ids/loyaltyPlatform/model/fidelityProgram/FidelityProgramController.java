package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public abstract class FidelityProgramController {

    @Autowired
    private FidelityProgramService service;

    @PutMapping("")
    public Optional<FidelityProgram> getFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        return this.service.get(fidelityProgram);
    }

    public FidelityProgram update(@NonNull FidelityProgram fidelityProgram) {
        return this.service.update(fidelityProgram);
    }

    @DeleteMapping("")
    public void deleteFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        this.service.delete(fidelityProgram);
    }

}
