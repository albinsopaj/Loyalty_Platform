package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelFidelityProgramRepository extends JpaRepository<LevelFidelityProgram, Long> {

}
