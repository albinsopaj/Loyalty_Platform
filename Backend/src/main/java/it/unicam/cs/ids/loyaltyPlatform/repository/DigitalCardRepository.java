package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.DigitalCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interface to manage all CRUD operations on the repository of {@link DigitalCard}.
 */
@Repository
public interface DigitalCardRepository extends JpaRepository<DigitalCard, UUID> {
}
