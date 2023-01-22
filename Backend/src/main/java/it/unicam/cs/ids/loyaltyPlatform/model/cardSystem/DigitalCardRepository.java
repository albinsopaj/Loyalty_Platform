package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to manage all CRUD operations on the repository of {@link DigitalCard}.
 */
@Repository
public interface DigitalCardRepository extends JpaRepository<DigitalCard, Long> {
}
