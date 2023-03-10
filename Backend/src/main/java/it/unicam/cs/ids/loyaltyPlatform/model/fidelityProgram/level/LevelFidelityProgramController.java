package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"}, maxAge = 3600)
@RestController
@RequestMapping(path = "loyaltyPlatform/levelFidelityProgram")
public class LevelFidelityProgramController {
    @Autowired
    private LevelFidelityProgramServiceImpl levelFidelityProgramService;

    @GetMapping(path = "/get/{id}")
    public LevelFidelityProgram get(@NonNull @PathVariable("id") Long id) {
        return this.levelFidelityProgramService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<LevelFidelityProgram> getAll() {
        return this.levelFidelityProgramService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.levelFidelityProgramService.deleteById(id);
    }

    @DeleteMapping(path = "delete/{levelFidelityProgram}")
    public void delete(@NonNull @RequestBody @PathVariable LevelFidelityProgram levelFidelityProgram) {
        this.levelFidelityProgramService.delete(levelFidelityProgram);
    }

}
