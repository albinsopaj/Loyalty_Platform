package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsDigitalCardRepository extends DigitalCardRepository<PointsDigitalCard, Long> {

}
