package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.PortafoglioDigitale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per gestire tutte le operazioni CRUD sul repository del {@link FidelityProgram}.
 */
@Repository
public interface FidelityProgramRepository extends JpaRepository<FidelityProgram, UUID> {
}
