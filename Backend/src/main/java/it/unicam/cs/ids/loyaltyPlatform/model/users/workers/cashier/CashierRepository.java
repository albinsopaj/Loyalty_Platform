package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRepository extends AuthenticatedUserRepository<Cashier, Long> {

}
