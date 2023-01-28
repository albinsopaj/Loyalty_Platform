package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.users.UserRepository;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OwnerServiceImpl {

    private UserRepository repository;

    public Owner save(@NonNull Owner owner) {
        if(!repository.findAll().contains(owner)){
            return this.repository.save(owner);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Owner already exists");
        }
    }
}
