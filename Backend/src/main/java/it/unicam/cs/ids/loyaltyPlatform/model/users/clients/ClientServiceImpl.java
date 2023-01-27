package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.users.UserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.UserServiceImpl;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClientServiceImpl extends UserServiceImpl {

    private UserRepository repository;

    public Client save(@NonNull Client Client) {
        if(!repository.findAll().contains(Client)){
            return this.repository.save(Client);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Client already exists");
        }
    }

}
