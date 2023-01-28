package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LevelFidelityProgramServiceImpl extends FidelityProgramServiceImpl {
    @Autowired
    private FidelityProgramRepository repository;

    public LevelFidelityProgram save(@NonNull LevelFidelityProgram fidelityProgram) {
        if(!repository.findAll().contains(fidelityProgram)){
            return this.repository.save(fidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "levelFidelityProgram already exists");
        }
    }
}
