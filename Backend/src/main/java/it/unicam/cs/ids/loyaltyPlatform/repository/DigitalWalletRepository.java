package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.PortafoglioDigitale;
import it.unicam.cs.ids.loyaltyPlatform.model.UtenteAutenticato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per gestire tutte le operazioni CRUD sul repository del {@link PortafoglioDigitale}.
 */
@Repository
public interface DigitalWalletRepository extends JpaRepository<PortafoglioDigitale, UUID> {
}
