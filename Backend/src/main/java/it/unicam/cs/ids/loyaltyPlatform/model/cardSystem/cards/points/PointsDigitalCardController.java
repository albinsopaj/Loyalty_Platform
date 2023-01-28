package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointsDigitalCardController extends DigitalCardController {
    @Autowired
    private PointsDigitalCardServiceImpl pointsDigitalCardService;

    @Autowired
    private PointsDigitalCard pointsDigitalCard;

    @PostMapping("/pointsDigitalCard")
    public PointsDigitalCard addPointsDigitalCard(@NonNull @RequestBody PointsDigitalCard pointsDigitalCard) {
        return this.pointsDigitalCardService.save(pointsDigitalCard);
    }
}
