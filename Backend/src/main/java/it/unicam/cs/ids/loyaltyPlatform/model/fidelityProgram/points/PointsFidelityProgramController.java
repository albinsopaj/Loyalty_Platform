package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "loyaltyPlatform/pointsFidelityProgram")
public class PointsFidelityProgramController {

    @Autowired
    private PointsFidelityProgramServiceImpl pointsFidelityProgramService;

    @GetMapping(path = "/get/{id}")
    public PointsFidelityProgram get(@NonNull @PathVariable("id") Long id) {
        return this.pointsFidelityProgramService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<PointsFidelityProgram> getAll() {
        return this.pointsFidelityProgramService.getAll();
    }

    @DeleteMapping(path = "/deleteById/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.pointsFidelityProgramService.deleteById(id);
    }

    @DeleteMapping(path = "delete/{pointsFidelityProgram}")
    public void delete(@NonNull @RequestBody @PathVariable PointsFidelityProgram pointsFidelityProgram) {
        this.pointsFidelityProgramService.delete(pointsFidelityProgram);
    }
}
