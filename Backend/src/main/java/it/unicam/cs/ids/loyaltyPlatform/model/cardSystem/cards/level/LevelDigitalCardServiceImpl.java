package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LevelDigitalCardServiceImpl extends DigitalCardServiceImpl {
    @Autowired
    private DigitalCardRepository repository;

    public LevelDigitalCard save(@NonNull LevelDigitalCard levelDigitalCard) {
        if(!repository.findAll().contains(levelDigitalCard)){
            return this.repository.save(levelDigitalCard);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "levelDigitalCard already exists");
        }
    }
}
