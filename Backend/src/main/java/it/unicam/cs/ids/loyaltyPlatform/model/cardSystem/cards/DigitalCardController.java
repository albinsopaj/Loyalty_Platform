package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public abstract class DigitalCardController {

    @Autowired
    private DigitalCardService cardService;

    private DigitalCard digitalCard;

    @GetMapping(path = "/DigitalCard/{digitalCardId}")
    public DigitalCard getDigitalCard(@NonNull @PathVariable("digitalCardId") Long id) {
        return this.cardService.findById(id);
    }

    @GetMapping(path = "/digitalCards")
    public List<DigitalCard> getAllDigitalCards() {
        return this.cardService.getAll();
    }

    @PutMapping(path = "/update/{digitalCard}")
    public DigitalCard updateDigitalCard(@NonNull @RequestBody @PathVariable("digitalCard") DigitalCard digitalCard) {
        return this.cardService.update(digitalCard);
    }

    /**
     * Method to remove a digital card from the wallet
     *
     * @param id the digital card's id to remove
     */
    @DeleteMapping(path = "/delete/{digitalCardId}")
    public void deleteDigitalCard(@NonNull @PathVariable("digitalCardId") Long id) {
        this.cardService.deleteById(id);
    }

    /**
     * Method to remove a digital card from the wallet
     *
     * @param digitalCard the digital card's id to remove
     */
    @DeleteMapping(path = "/delete/{digitalCard}")
    public void deleteDigitalCard(@NonNull @PathVariable("digitalCard") DigitalCard digitalCard) {
        this.cardService.delete(digitalCard);
    }

}