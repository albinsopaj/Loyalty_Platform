package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class PointsRewardServiceImpl implements GeneralService<PointsReward> {
    @Autowired
    private PointsRewardRepository repository;

    @Override
    public PointsReward save(@NonNull PointsReward pointsReward) {
        if (!repository.findAll().contains(pointsReward)) {
            return this.repository.save(pointsReward);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Points reward already exists");
        }
    }
    @Override
    public PointsReward findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Points reward not found"));
    }

    @Override
    public Optional<PointsReward> get(@NonNull PointsReward pointsReward) {
        return this.repository.findById(pointsReward.getId());
    }
    @Override
    public List<PointsReward> getAll() {
        return this.repository.findAll();
    }
    @Override
    public PointsReward update(@NonNull PointsReward pointsReward) {
        return this.repository.save(pointsReward);
    }
    @Override
    public PointsReward updateById(@NonNull Long id) {
        //TODO
        return null;
    }
    @Override
    public void delete(@NonNull PointsReward pointsReward) {
        this.repository.delete(pointsReward);
    }
    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }


}
