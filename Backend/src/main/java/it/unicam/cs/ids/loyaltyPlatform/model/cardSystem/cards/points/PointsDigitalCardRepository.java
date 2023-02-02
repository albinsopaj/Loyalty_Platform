package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsDigitalCardRepository extends JpaRepository<PointsDigitalCard, Long> {

}
