package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointsFidelityProgramController extends FidelityProgramController {
    @Autowired
    private PointsFidelityProgramServiceImpl pointsFidelityProgramService;

    @Autowired
    private PointsFidelityProgram pointsFidelityProgram;

    @PostMapping("/pointsFidelityProgram")
    public PointsFidelityProgram addPointsFidelityProgram(@NonNull @RequestBody PointsFidelityProgram pointsFidelityProgram) {
        return this.pointsFidelityProgramService.save(pointsFidelityProgram);
    }
}
