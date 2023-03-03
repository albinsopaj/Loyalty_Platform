package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<Manager> findByUsername(String username);
}
