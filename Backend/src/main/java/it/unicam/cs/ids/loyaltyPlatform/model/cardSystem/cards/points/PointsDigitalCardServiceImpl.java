package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PointsDigitalCardServiceImpl extends DigitalCardServiceImpl {

    @Autowired
    private DigitalCardRepository repository;

    public PointsDigitalCard save(@NonNull PointsDigitalCard pointsDigitalCard) {
        if(!repository.findAll().contains(pointsDigitalCard)){
            return this.repository.save(pointsDigitalCard);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "pointsDigitalCard already exists");
        }
    }
}
