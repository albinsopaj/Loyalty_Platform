package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CashierRepository extends JpaRepository<Cashier, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<Cashier> findByUsername(String username);
}
