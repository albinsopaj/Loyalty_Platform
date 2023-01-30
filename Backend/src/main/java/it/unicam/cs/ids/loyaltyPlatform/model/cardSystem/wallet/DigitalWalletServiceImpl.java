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
public class DigitalWalletServiceImpl implements GeneralService<DigitalWallet> {

    @Autowired
    private DigitalWalletRepository repository;

    @Override
    public DigitalWallet save(@NonNull DigitalWallet digitalWallet) {
        return this.repository.save(digitalWallet);
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
    public DigitalWallet update(DigitalWallet digitalCard) {
        //TODO da verificare il comportamento e anche la validazione
        return this.repository.save(digitalCard);
    }

    @Override
    public DigitalWallet updateById(@NonNull Long id) {
        //TODO to be reviewed
        Optional<DigitalWallet> oldDigitalWallet = this.repository.findById(id);

        if (oldDigitalWallet.isPresent()) {
            DigitalWallet originalDigitalWallet = oldDigitalWallet.get();
            return this.repository.save(originalDigitalWallet);
        }
        return null;
    }

    @Override
    public void delete(@NonNull DigitalWallet digitalCard) {
        //da verificare se l'elemento da cancellare è presente o no
        this.repository.delete(digitalCard);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        //da verificare se l'elemento da cancellare è presente o no
        this.repository.deleteById(id);
    }
}
