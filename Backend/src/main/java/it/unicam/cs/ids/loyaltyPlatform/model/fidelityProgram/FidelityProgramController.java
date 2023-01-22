package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FidelityProgramController {

    @Autowired
    private FidelityProgramService service;

    @PostMapping("")
    public FidelityProgram addFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        return this.service.addFidelityProgram(fidelityProgram);
    }

    @PutMapping("")
    public Optional<FidelityProgram> getFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        return this.service.getFidelityProgram(fidelityProgram);
    }

    public FidelityProgram updateFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        return this.service.updateFidelityProgram(fidelityProgram);
    }

    @DeleteMapping("")
    public void deleteFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        this.service.deleteFidelityProgram(fidelityProgram);
    }

}
