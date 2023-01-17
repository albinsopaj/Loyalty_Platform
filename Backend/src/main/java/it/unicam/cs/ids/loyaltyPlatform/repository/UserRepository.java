package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Interface to manage all CRUD operations on the repository of {@link AuthenticatedUser}.
 */
@Repository
public interface UserRepository extends JpaRepository<AuthenticatedUser, UUID> {

    AuthenticatedUser getUserByUsername(@Param("email") String email);

    AuthenticatedUser addUser(AuthenticatedUser user);

    boolean existsByEmail(String email);

    List<AuthenticatedUser> findByName(String name);

    List<AuthenticatedUser> findByEmail(String email);

    boolean existsByID(String email);

}
