package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Interface to manage all CRUD operations on the repository of {@link AuthenticatedUserInterface}.
 */
@Repository
public interface UserRepository extends JpaRepository<AuthenticatedUserInterface, UUID> {

    //@Query("SELECT u FROM AuthenticatedUser u WHERE u.email = :email")
    AuthenticatedUserInterface getUserByUsername(@Param("email") String email);

    //@Query("SELECT u FROM ...");
    AuthenticatedUserInterface findByUsername(@Param("username") String username);

    AuthenticatedUserInterface addUser(AuthenticatedUserInterface user);

    List<AuthenticatedUserInterface> findAllBy
    boolean existsByEmail(String email);
}
