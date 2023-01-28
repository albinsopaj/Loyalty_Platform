package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelFidelityProgramController extends FidelityProgramController {
    @Autowired
    private LevelFidelityProgramServiceImpl levelFidelityProgramService;

    @Autowired
    private LevelFidelityProgram levelFidelityProgram;

    @PostMapping("/levelFidelityProgram")
    public LevelFidelityProgram addLevelFidelityProgram(@NonNull @RequestBody LevelFidelityProgram levelFidelityProgram) {
        return this.levelFidelityProgramService.save(levelFidelityProgram);
    }
}
