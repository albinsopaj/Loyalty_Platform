package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticatedUserServiceImpl implements AuthenticatedUserService {

    @Autowired
    private AuthenticatedUserRepository repository;

    @Override
    public AuthenticatedUser save(@NonNull AuthenticatedUser authenticatedUser) {
        return null;
    }

    @Override
    public AuthenticatedUser saveById(@NonNull Long id) {
        return null;
    }

    @Override
    public AuthenticatedUser findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Override
    public Optional<AuthenticatedUser> get(@NonNull AuthenticatedUser authenticatedUser) {
        return this.repository.findById(authenticatedUser.getId());
    }

    @Override
    public List<AuthenticatedUser> getAll() {
        return this.repository.findAll();
    }


    @Override
    public AuthenticatedUser update(@NonNull AuthenticatedUser authenticatedUser) {
        return this.repository.save(authenticatedUser);
    }

    @Override
    public AuthenticatedUser updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull AuthenticatedUser authenticatedUser) {
        this.repository.delete(authenticatedUser);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void deleteByEmail(@NonNull String email) {
        for(AuthenticatedUser authenticatedUser: this.repository.findAll()){
            if(authenticatedUser.getEmail().equals(email)){
                delete(authenticatedUser);
            }
        }
    }
}
