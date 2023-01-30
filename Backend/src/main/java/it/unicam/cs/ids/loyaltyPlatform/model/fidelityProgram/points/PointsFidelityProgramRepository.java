package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsFidelityProgramRepository extends JpaRepository<PointsFidelityProgram, Long> {
}
