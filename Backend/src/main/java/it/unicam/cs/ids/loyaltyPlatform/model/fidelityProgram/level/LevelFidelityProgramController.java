package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/levelFidelityProgram")
public class LevelFidelityProgramController {
    @Autowired
    private LevelFidelityProgramServiceImpl levelFidelityProgramService;

    @PostMapping(path = "/levelFidelityProgram")
    public LevelFidelityProgram add(@NonNull @RequestBody LevelFidelityProgram levelFidelityProgram) {
        return this.levelFidelityProgramService.save(levelFidelityProgram);
    }

    @GetMapping(path = "/get/{id}")
    public LevelFidelityProgram get(@NonNull @PathVariable("id") Long id) {
        return this.levelFidelityProgramService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<LevelFidelityProgram> getAll() {
        return this.levelFidelityProgramService.getAll();
    }

    @PutMapping(path = "/update/{levelFidelityProgram}")
    public LevelFidelityProgram update(@NonNull @RequestBody @PathVariable("levelFidelityProgram") LevelFidelityProgram levelFidelityProgram) {
        return this.levelFidelityProgramService.update(levelFidelityProgram);
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
