package it.unicam.cs.ids.loyaltyPlatform.model.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

/**
 * Interface to manage all CRUD operations on the repository of {@link AuthenticatedUser}.
 */
@Repository
public interface AuthenticatedUserRepository extends JpaRepository<AuthenticatedUser, Long> {

}
