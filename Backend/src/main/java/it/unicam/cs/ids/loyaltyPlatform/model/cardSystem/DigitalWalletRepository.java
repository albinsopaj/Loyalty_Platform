package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to manage all CRUD operations on the repository of {@link DigitalWallet}.
 */
@Repository
public interface DigitalWalletRepository extends JpaRepository<DigitalWallet, Long> {
}
