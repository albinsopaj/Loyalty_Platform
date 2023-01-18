package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalWallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interface to manage all CRUD operations on the repository of {@link DigitalWallet}.
 */
@Repository
public interface DigitalWalletRepository extends JpaRepository<DigitalWallet, UUID> {
}
