package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.PointsFidelityProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interface to manage all CRUD operations on the repository of {@link PointsFidelityProgram}.
 */
@Repository
public interface FidelityProgramRepository extends JpaRepository<PointsFidelityProgram, UUID> {
}
