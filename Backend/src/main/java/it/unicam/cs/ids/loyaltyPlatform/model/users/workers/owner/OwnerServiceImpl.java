package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements AuthenticatedUserService<Owner> {

    @Autowired
    private OwnerRepository repository;

    public Owner save(@NonNull Owner owner) {
        if (!repository.findAll().contains(owner)) {
            return this.repository.save(owner);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Owner already exists");
        }
    }

    @Override
    public Owner findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Owner not found"));
    }

    @Override
    public Optional<Owner> get(@NonNull Owner owner) {
        return this.repository.findById(owner.getId());
    }

    @Override
    public List<Owner> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Owner update(@NonNull Owner owner) {
        return this.repository.save(owner);
    }

    @Override
    public Owner updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull Owner owner) {
        this.repository.delete(owner);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

}
