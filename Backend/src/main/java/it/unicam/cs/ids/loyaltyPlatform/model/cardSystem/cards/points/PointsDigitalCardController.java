package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/pointsDigitalCards")
public class PointsDigitalCardController {
    @Autowired
    private PointsDigitalCardServiceImpl pointsDigitalCardService;

    @PostMapping("/pointsDigitalCard")
    public PointsDigitalCard add(@NonNull @RequestBody PointsDigitalCard pointsDigitalCard) {
        return this.pointsDigitalCardService.save(pointsDigitalCard);
    }

    @GetMapping("/{id}")
    public PointsDigitalCard get(@NonNull Long id) {
        return this.pointsDigitalCardService.findById(id);
    }

    @GetMapping("/getAll")
    public List<PointsDigitalCard> getAll() {
        return this.pointsDigitalCardService.getAll();
    }

    @PutMapping("/update/{pointsDigitalCard}")
    public PointsDigitalCard update(@NonNull @RequestBody @PathVariable("pointsDigitalCard") PointsDigitalCard pointsDigitalCard) {
        return this.pointsDigitalCardService.update(pointsDigitalCard);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.pointsDigitalCardService.delete(id);
    }

    @DeleteMapping("delete/{pointsDigitalCard}")
    public void delete(@NonNull @RequestBody @PathVariable PointsDigitalCard pointsDigitalCard) {
        this.pointsDigitalCardService.delete(pointsDigitalCard);
    }

}
