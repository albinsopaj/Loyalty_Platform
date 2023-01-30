package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points;

import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class PointsDigitalCardServiceImpl implements GeneralService<PointsDigitalCard> {
    @Autowired
    private PointsDigitalCardRepository repository;

    @Override
    public PointsDigitalCard save(@NonNull PointsDigitalCard pointsDigitalCard) {
        if (!repository.findAll().contains(pointsDigitalCard)) {
            return this.repository.save(pointsDigitalCard);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Digital card already exists");
        }
    }

    @Override
    public PointsDigitalCard findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Digital card not found"));
    }

    @Override
    public Optional<PointsDigitalCard> get(@NonNull PointsDigitalCard pointsDigitalCard) {
        return this.repository.findById(pointsDigitalCard.getId());
    }

    @Override
    public List<PointsDigitalCard> getAll() {
        return this.repository.findAll();
    }

    @Override
    public PointsDigitalCard update(@NonNull PointsDigitalCard pointsDigitalCard) {
        return this.repository.save(pointsDigitalCard);
    }

    @Override
    public PointsDigitalCard updateById(@NonNull Long id) {
        //TODO
        return null;
    }

    @Override
    public void delete(@NonNull PointsDigitalCard pointsDigitalCard) {
        this.repository.delete(pointsDigitalCard);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    public void addPoints(@NonNull PointsDigitalCard pointsDigitalCard, @NonNull Integer points){
       pointsDigitalCard.setPoints(pointsDigitalCard.getPoints() + points);
    }
}
