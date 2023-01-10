package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.PointsFidelityProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per gestire tutte le operazioni CRUD sul repository del {@link PointsFidelityProgram}.
 */
@Repository
public interface FidelityProgramRepository extends JpaRepository<PointsFidelityProgram, UUID> {
}
