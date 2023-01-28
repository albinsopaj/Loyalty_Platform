package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends AuthenticatedUserRepository<Owner, Long> {

}
