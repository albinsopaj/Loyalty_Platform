package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelDigitalCardRepository extends JpaRepository<LevelDigitalCard, Long> {

}
