package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CashierServiceImpl implements AuthenticatedUserService<Cashier> {

    @Autowired
    private CashierRepository repository;

    public Cashier save(@NonNull Cashier cashier) {
        if (!repository.findAll().contains(cashier)) {
            return this.repository.save(cashier);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Cashier already exists");
        }
    }

    @Override
    public Cashier findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "cashier not found"));
    }

    @Override
    public Optional<Cashier> get(@NonNull Cashier cashier) {
        return this.repository.findById(cashier.getId());
    }

    @Override
    public List<Cashier> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Cashier update(@NonNull Cashier cashier) {
        return this.repository.save(cashier);
    }

    @Override
    public Cashier updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull Cashier cashier) {
        this.repository.delete(cashier);
    }

    @Override
    public void delete(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public void delete(@NonNull String email) {
        for(Cashier cashier: this.repository.findAll()){
            if(cashier.getEmail().equals(email)){
                delete(cashier);
            }
        }
    }

}
