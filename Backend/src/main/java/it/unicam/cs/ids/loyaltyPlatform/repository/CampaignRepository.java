package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per gestire tutte le operazioni CRUD sul repository del {@link Campaign}.
 */
@Repository
public interface CampaignRepository extends JpaRepository<Campaign, UUID> {
}
