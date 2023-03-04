package it.unicam.cs.ids.loyaltyPlatform.model.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Interface to manage all CRUD operations on the repository of {@link AuthenticatedUser}.
 */
@Repository
public interface AuthenticatedUserRepository extends JpaRepository<AuthenticatedUser, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<AuthenticatedUser> findByUsername(String username);
}

