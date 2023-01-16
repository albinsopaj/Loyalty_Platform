package it.unicam.cs.ids.loyaltyPlatform.service;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import it.unicam.cs.ids.loyaltyPlatform.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public AuthenticatedUser addUser(@NonNull AuthenticatedUser user) {
        if (userExists(user.getID())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is already present!");
        }
        return this.repository.save(user);
    }

    public Optional<AuthenticatedUser> getUser(@NonNull UUID id) {
        if (this.userExists(id) || this.repository.existsById(id)) {
            return this.repository.findById(id);
        }
        return Optional.empty();
    }

    public AuthenticatedUser getUser(@NonNull String email) {
        return this.repository.getUserByUsername(email);
    }

    //TODO incomplete method
    public void deleteUser(@NonNull String email) {
        if (userExists(email)) {
            this.repository.delete(getUser(email));
        }
    }

    public void deleteUser(@NonNull UUID id) {
        if (userExists(id)) {
            this.repository.deleteById(id);
        }
    }

    //TODO incomplete method definition
    public AuthenticatedUser updateAuthenticatedUser(@NonNull AuthenticatedUser user) {
        Optional<AuthenticatedUser> oldUser = this.repository.findById(user.getID());
        return this.repository.save(user);
    }

    private boolean userExists(@NonNull UUID id) {
        return this.repository.existsById(id);
    }

    //TODO incomplete method. method existsByEmail() in UserRepository isn't complete.
    private boolean userExists(@NonNull String email) {
        return this.repository.existsByEmail(email);
    }

}
