package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public AuthenticatedUser addUser(@NonNull AuthenticatedUser user) {
//        if (userExists(user.getID())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is already present!");
//        }
        return this.repository.save(user);
    }

    public Optional<AuthenticatedUser> getUser(@NonNull Long id) {
        if (this.userExists(id) || this.repository.existsById(id)) {
            return this.repository.findById(id);
        }
        return Optional.empty();
    }

    public AuthenticatedUser getUser(@NonNull AuthenticatedUser user) {
        //TODO implement
        return null;
    }

    public void deleteUser(@NonNull Long id) {
        if (userExists(id)) {
            this.repository.deleteById(id);
        }
    }

    //TODO incomplete method definition
    public AuthenticatedUser updateAuthenticatedUser(@NonNull AuthenticatedUser user) {
//        Optional<AuthenticatedUser> oldUser = this.repository.findById(user.getID());
        return this.repository.save(user);
    }

    private boolean userExists(@NonNull Long id) {
        return this.repository.existsById(id);
    }

    //TODO incomplete method. method existsByEmail() in UserRepository isn't complete.
    private boolean userExists(@NonNull String email) {
        return this.repository.existsByEmail(email);
    }

}
