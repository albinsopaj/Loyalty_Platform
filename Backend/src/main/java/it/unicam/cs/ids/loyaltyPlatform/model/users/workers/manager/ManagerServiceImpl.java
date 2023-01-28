package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import it.unicam.cs.ids.loyaltyPlatform.model.users.UserRepository;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ManagerServiceImpl {
    private UserRepository repository;

    public Manager save(@NonNull Manager manager) {
        if(!repository.findAll().contains(manager)){
            return this.repository.save(manager);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Manager already exists");
        }
    }
}
