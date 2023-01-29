package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;


import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/levelDigitalCards")
public class LevelDigitalCardController {
    @Autowired
    private LevelDigitalCardServiceImpl levelDigitalCardService;

    @Autowired
    private LevelDigitalCard levelDigitalCard;

    @PostMapping("/levelDigitalCard")
    public LevelDigitalCard add(@NonNull @RequestBody LevelDigitalCard levelDigitalCard) {
        return this.levelDigitalCardService.save(levelDigitalCard);
    }

    @GetMapping("/{id}")
    public LevelDigitalCard get(@NonNull Long id) {
        return this.levelDigitalCardService.findById(id);
    }

    @GetMapping("/getAll")
    public List<LevelDigitalCard> getAll() {
        return this.levelDigitalCardService.getAll();
    }

    @PutMapping("/update/{levelDigitalCard}")
    public LevelDigitalCard update(@NonNull @RequestBody @PathVariable("levelDigitalCard") LevelDigitalCard levelDigitalCard) {
        return this.levelDigitalCardService.update(levelDigitalCard);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.levelDigitalCardService.delete(id);
    }

    @DeleteMapping("delete/{levelDigitalCard}")
    public void delete(@NonNull @RequestBody @PathVariable LevelDigitalCard levelDigitalCard) {
        this.levelDigitalCardService.delete(levelDigitalCard);
    }
}
