package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelDigitalCardRepository extends DigitalCardRepository<LevelDigitalCard, Long> {

}
