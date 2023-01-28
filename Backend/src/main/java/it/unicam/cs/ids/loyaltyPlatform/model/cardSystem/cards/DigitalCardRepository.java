package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface to manage all CRUD operations on the repository of {@link DigitalCard}.
 */
@NoRepositoryBean
public interface DigitalCardRepository<T extends DigitalCard, Long> extends JpaRepository<T, Long> {
}
