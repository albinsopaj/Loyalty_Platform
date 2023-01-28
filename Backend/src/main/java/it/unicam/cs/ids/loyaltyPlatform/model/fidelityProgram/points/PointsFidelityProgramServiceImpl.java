package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PointsFidelityProgramServiceImpl extends FidelityProgramServiceImpl {
    @Autowired
    private FidelityProgramRepository repository;

    public PointsFidelityProgram save(@NonNull PointsFidelityProgram fidelityProgram) {
        if(!repository.findAll().contains(fidelityProgram)){
            return this.repository.save(fidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "pointsFidelityProgram already exists");
        }
    }
}
