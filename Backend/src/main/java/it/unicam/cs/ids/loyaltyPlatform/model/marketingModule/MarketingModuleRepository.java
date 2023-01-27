package it.unicam.cs.ids.loyaltyPlatform.model.marketingModule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MarketingModuleRepository extends JpaRepository<MarketingModule, Long> {
}
