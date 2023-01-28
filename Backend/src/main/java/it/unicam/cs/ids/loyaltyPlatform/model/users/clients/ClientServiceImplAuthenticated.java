package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientServiceImplAuthenticated extends AuthenticatedUserServiceImpl {

    @Autowired
    private AuthenticatedUserRepository repository;

    public Client save(@NonNull Client client) {
        if (!repository.findAll().contains(client)) {
            return this.repository.save(client);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Client already exists");
        }
    }
}
