package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards;

import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class DigitalCardServiceImpl implements GeneralService<DigitalCard> {

    @Autowired
    private DigitalCardRepository repository;

    @Override
    public DigitalCard save(@NonNull DigitalCard digitalCard) {
        if (!repository.findAll().contains(digitalCard)) {
            return this.repository.save(digitalCard);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Digital card already exists");
        }
    }

    @Override
    public DigitalCard update(@NonNull DigitalCard digitalCard) {
        return this.repository.save(digitalCard);
    }

    @Override
    public DigitalCard updateById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Digital card not found"));
    }

    @Override
    public DigitalCard findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Digital card not found"));
    }

    @Override
    public Optional<DigitalCard> get(@NonNull DigitalCard digitalCard) {
        return this.repository.findById(digitalCard.getId());
    }

    @Override
    public List<DigitalCard> getAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(@NonNull DigitalCard digitalCard) {
        this.repository.delete(digitalCard);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

}
