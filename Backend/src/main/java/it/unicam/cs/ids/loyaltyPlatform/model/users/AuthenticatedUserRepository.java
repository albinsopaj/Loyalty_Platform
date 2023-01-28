package it.unicam.cs.ids.loyaltyPlatform.model.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface to manage all CRUD operations on the repository of {@link AuthenticatedUser}.
 */
@NoRepositoryBean
public interface AuthenticatedUserRepository<T extends  AuthenticatedUser, Long> extends JpaRepository<T, Long> {

}
