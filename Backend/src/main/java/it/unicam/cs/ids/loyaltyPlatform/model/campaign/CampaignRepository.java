package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interface to manage all CRUD operations on the repository of {@link Campaign}.
 */
@Repository
@Transactional
public interface CampaignRepository extends JpaRepository<Campaign, UUID> {
}
