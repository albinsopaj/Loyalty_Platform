package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/pointsFidelityPrograms")
public class PointsFidelityProgramController {
    @Autowired
    private PointsFidelityProgramServiceImpl pointsFidelityProgramService;

    @Autowired
    private PointsFidelityProgram pointsFidelityProgram;

    @PostMapping("/pointsFidelityProgram")
    public PointsFidelityProgram add(@NonNull @RequestBody PointsFidelityProgram pointsFidelityProgram) {
        return this.pointsFidelityProgramService.save(pointsFidelityProgram);
    }

    @GetMapping("/{id}")
    public PointsFidelityProgram get(@NonNull Long id) {
        return this.pointsFidelityProgramService.findById(id);
    }

    @GetMapping("/getAll")
    public List<PointsFidelityProgram> getAll() {
        return this.pointsFidelityProgramService.getAll();
    }

    @PutMapping("/update/{pointsFidelityProgram}")
    public PointsFidelityProgram update(@NonNull @RequestBody @PathVariable("pointsFidelityProgram") PointsFidelityProgram pointsFidelityProgram) {
        return this.pointsFidelityProgramService.update(pointsFidelityProgram);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.pointsFidelityProgramService.delete(id);
    }

    @DeleteMapping("delete/{pointsFidelityProgram}")
    public void delete(@NonNull @RequestBody @PathVariable PointsFidelityProgram pointsFidelityProgram) {
        this.pointsFidelityProgramService.delete(pointsFidelityProgram);
    }
}
