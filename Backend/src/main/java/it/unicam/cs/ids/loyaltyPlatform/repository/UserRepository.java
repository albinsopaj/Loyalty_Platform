package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.AuthenticatedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interface to manage all CRUD operations on the repository of {@link AuthenticatedUser}.
 */
@Repository
public interface UserRepository extends JpaRepository<AuthenticatedUser, UUID> {

    //@Query("SELECT u FROM AuthenticatedUser u WHERE u.email = :email")
    AuthenticatedUser getUserByUsername(@Param("email") String email);

    //@Query("SELECT u FROM ...");
    AuthenticatedUser findByUsername(@Param("username") String username);

    AuthenticatedUser addUser(AuthenticatedUser user);

    boolean existsByEmail(String email);
}
