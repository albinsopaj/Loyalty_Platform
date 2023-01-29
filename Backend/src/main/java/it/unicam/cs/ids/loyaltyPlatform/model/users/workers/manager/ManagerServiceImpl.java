package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements AuthenticatedUserService<Manager> {

    @Autowired
    private ManagerRepository repository;

    public Manager save(@NonNull Manager manager) {
        if (!repository.findAll().contains(manager)) {
            return this.repository.save(manager);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "manager already exists");
        }
    }

    @Override
    public Manager findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "manager not found"));
    }

    @Override
    public Optional<Manager> get(@NonNull Manager manager) {
        return this.repository.findById(manager.getId());
    }

    @Override
    public List<Manager> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Manager update(@NonNull Manager manager) {
        return this.repository.save(manager);
    }

    @Override
    public Manager updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull Manager manager) {
        this.repository.delete(manager);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

}
