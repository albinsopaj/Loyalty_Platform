package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to manage all CRUD operations on the repository of {@link PointsFidelityProgram}.
 */
@Repository
public interface FidelityProgramRepository extends JpaRepository<FidelityProgram, Long> {

}
