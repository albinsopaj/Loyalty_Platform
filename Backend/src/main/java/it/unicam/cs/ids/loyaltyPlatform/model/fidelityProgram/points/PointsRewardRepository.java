package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsRewardRepository extends JpaRepository<PointsReward, Long> {

}
