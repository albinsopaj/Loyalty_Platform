package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;

import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class LevelDigitalCardServiceImpl implements GeneralService<LevelDigitalCard> {
    @Autowired
    private LevelDigitalCardRepository repository;

    @Override
    public LevelDigitalCard save(@NonNull LevelDigitalCard levelDigitalCard) {
        if (!repository.findAll().contains(levelDigitalCard)) {
            return this.repository.save(levelDigitalCard);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Digital card already exists");
        }
    }

    @Override
    public LevelDigitalCard findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Digital card not found"));
    }

    @Override
    public Optional<LevelDigitalCard> get(@NonNull LevelDigitalCard levelDigitalCard) {
        return this.repository.findById(levelDigitalCard.getId());
    }

    @Override
    public List<LevelDigitalCard> getAll() {
        return this.repository.findAll();
    }

    @Override
    public LevelDigitalCard update(@NonNull LevelDigitalCard levelDigitalCard) {
        return this.repository.save(levelDigitalCard);
    }

    @Override
    public LevelDigitalCard updateById(@NonNull Long id) {
        //TODO
        return null;
    }

    @Override
    public void delete(@NonNull LevelDigitalCard levelDigitalCard) {
        this.repository.delete(levelDigitalCard);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

}
