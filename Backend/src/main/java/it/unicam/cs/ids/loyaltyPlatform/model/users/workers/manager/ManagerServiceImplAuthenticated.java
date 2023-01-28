package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ManagerServiceImplAuthenticated extends AuthenticatedUserServiceImpl {
    @Autowired
    private AuthenticatedUserRepository repository;

    /**
     *  Method to save  a manager
     *
     * @param manager the manager to save
     * @return
     */
    public Manager save(@NonNull Manager manager) {
        if (!repository.findAll().contains(manager)) {
            return this.repository.save(manager);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Manager already exists");
        }
    }
}
