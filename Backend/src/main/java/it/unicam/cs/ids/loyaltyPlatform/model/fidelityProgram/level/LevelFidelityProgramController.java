package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/levelFidelityPrograms")
public class LevelFidelityProgramController {
    @Autowired
    private LevelFidelityProgramServiceImpl levelFidelityProgramService;

    @Autowired
    private LevelFidelityProgram levelFidelityProgram;

    @PostMapping("/levelFidelityProgram")
    public LevelFidelityProgram add(@NonNull @RequestBody LevelFidelityProgram levelFidelityProgram) {
        return this.levelFidelityProgramService.save(levelFidelityProgram);
    }

    @GetMapping("/{id}")
    public LevelFidelityProgram get(@NonNull Long id) {
        return this.levelFidelityProgramService.findById(id);
    }

    @GetMapping("/getAll")
    public List<LevelFidelityProgram> getAll() {
        return this.levelFidelityProgramService.getAll();
    }

    @PutMapping("/update/{levelFidelityProgram}")
    public LevelFidelityProgram update(@NonNull @RequestBody @PathVariable("levelFidelityProgram") LevelFidelityProgram levelFidelityProgram) {
        return this.levelFidelityProgramService.update(levelFidelityProgram);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.levelFidelityProgramService.delete(id);
    }

    @DeleteMapping("delete/{levelFidelityProgram}")
    public void delete(@NonNull @RequestBody @PathVariable LevelFidelityProgram levelFidelityProgram) {
        this.levelFidelityProgramService.delete(levelFidelityProgram);
    }
}
