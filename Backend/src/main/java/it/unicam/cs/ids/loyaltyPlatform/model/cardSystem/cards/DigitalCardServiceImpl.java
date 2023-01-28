package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

public class DigitalCardServiceImpl implements DigitalCardService {
    @Autowired
    private DigitalCardRepository repository;

    @Override
    public DigitalCard saveById(@NonNull Long id) {
        return this.repository.save(this.findById(id));
    }

    @Override
    public DigitalCard findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Digital Card not found"));
    }

    @Override
    public List<DigitalCard> getAll() {
        return this.repository.findAll();
    }

    @Override
    public DigitalCard update(@NonNull DigitalCard digitalCard) {
        return this.repository.save(digitalCard);
    }

    @Override
    public DigitalCard updateById(@NonNull Long id) {

        Optional<DigitalCard> oldDigitalCard = this.repository.findById(id);

        if (oldDigitalCard.isPresent()) {
            DigitalCard orgDigitalCard = oldDigitalCard.get();
            return this.repository.save(orgDigitalCard);
        }
        return null;
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
