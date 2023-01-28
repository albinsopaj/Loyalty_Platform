package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends AuthenticatedUserRepository<Client,Long> {
}
