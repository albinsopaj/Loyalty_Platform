package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CashierServiceImpl extends AuthenticatedUserServiceImpl {
    @Autowired
    private AuthenticatedUserRepository repository;

    public Cashier save(@NonNull Cashier cashier) {
        if (!repository.findAll().contains(cashier)) {
            return this.repository.save(cashier);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Cashier already exists");
        }
    }

}
