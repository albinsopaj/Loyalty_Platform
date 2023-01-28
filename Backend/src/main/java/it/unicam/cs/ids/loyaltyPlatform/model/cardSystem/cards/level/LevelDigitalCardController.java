package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelDigitalCardController extends DigitalCardController {
    @Autowired
    private LevelDigitalCardServiceImpl levelDigitalCardService;

    @Autowired
    private LevelDigitalCard levelDigitalCard;

    @PostMapping("/levelDigitalCard")
    public LevelDigitalCard addLevelDigitalCard(@NonNull @RequestBody LevelDigitalCard levelDigitalCard) {
        return this.levelDigitalCardService.save(levelDigitalCard);
    }
}
