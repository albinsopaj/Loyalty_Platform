package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet;

import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class
DigitalWalletServiceImpl implements GeneralService<DigitalWallet> {

    @Autowired
    private DigitalWalletRepository repository;

    public DigitalWallet save(@NonNull DigitalWallet digitalWallet) {
        if (!repository.findAll().contains(digitalWallet)) {
            return this.repository.save(digitalWallet);
        } else throw new ResponseStatusException(HttpStatus.FOUND, "Digital wallet already exists");
    }

    @Override
    public DigitalWallet findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Digital Wallet not found"));
    }

    @Override
    public Optional<DigitalWallet> get(@NonNull DigitalWallet digitalWallet) {
        return this.repository.findById(digitalWallet.getId());
    }

    @Override
    public List<DigitalWallet> getAll() {
        return this.repository.findAll();
    }

    @Override
    public DigitalWallet update(DigitalWallet digitalWallet) {
        return this.repository.save(digitalWallet);
    }

    @Override
    public DigitalWallet updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull DigitalWallet digitalCard) {
        this.repository.delete(digitalCard);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    public void deleteAll(){
        this.repository.deleteAll();
    }
}
