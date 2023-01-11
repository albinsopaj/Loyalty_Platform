package it.unicam.cs.ids.loyaltyPlatform.service;

import it.unicam.cs.ids.loyaltyPlatform.model.AuthenticatedUser;
import it.unicam.cs.ids.loyaltyPlatform.repository.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<AuthenticatedUser> getAllUsers() {
    }

    public AuthenticatedUser getUserByID(UUID id) {

    }

    public AuthenticatedUser addAuthenticatedUser(@NonNull AuthenticatedUser user) {
        if (userExists(user.getID()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is already present!");
        return repository.addUser(user);
    }

    //TODO incomplete method
    public boolean deleteUser(@NonNull String email) {
        if (userExists(email)) {
            this.repository.deleteByEmail();    //TODO method deleteByEmail is not defined.
            return true;
        }
        return false;
    }

    public boolean deleteUser(@NonNull UUID id) {
        if (userExists(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    //TODO incomplete method definition
    public AuthenticatedUser updateAuthenticatedUser(@NonNull AuthenticatedUser user) {
        Optional<AuthenticatedUser> oldUser = this.repository.findById(user.getID());
        //TODO implement method body
    }

    private boolean userExists(@NonNull UUID id) {
        return this.repository.existsById(id);
    }

    //TODO incomplete method. method existsByEmail() in UserRepository isn't complete.
    private boolean userExists(@NonNull String email) {
        return this.repository.existsByEmail(email);
    }

}
