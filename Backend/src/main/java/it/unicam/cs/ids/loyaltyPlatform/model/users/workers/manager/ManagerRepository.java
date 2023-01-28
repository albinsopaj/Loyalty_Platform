package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends AuthenticatedUserRepository<Manager, Long> {
}
