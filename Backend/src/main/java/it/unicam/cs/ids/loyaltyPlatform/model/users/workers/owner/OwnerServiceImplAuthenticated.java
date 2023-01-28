package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OwnerServiceImplAuthenticated extends AuthenticatedUserServiceImpl {
    @Autowired
    private AuthenticatedUserRepository repository;

    /**
     *  Method to add a owner
     *
     * @param owner the owner to save
     * @return
     */
    public Owner save(@NonNull Owner owner) {
        if (!repository.findAll().contains(owner)) {
            return this.repository.save(owner);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Owner already exists");
        }
    }
}
