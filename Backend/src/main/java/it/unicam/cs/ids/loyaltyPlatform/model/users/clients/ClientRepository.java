package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<Client> findByUsername(String username);
}
