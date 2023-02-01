package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;


import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points.PointsDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points.PointsDigitalCardServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class PointsFidelityProgramServiceImpl implements GeneralService<PointsFidelityProgram> {

    @Autowired
    private PointsFidelityProgramRepository repository;

    @Autowired
    private PointsDigitalCardServiceImpl digitalCardService;
    @Override
    public PointsFidelityProgram save(@NonNull PointsFidelityProgram fidelityProgram) {
        if (!repository.findAll().contains(fidelityProgram)) {
            return this.repository.save(fidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Fidelity program already exists");
        }
    }

    @Override
    public PointsFidelityProgram findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelity Program not found"));
    }

    @Override
    public Optional<PointsFidelityProgram> get(@NonNull PointsFidelityProgram PointsFidelityProgram) {
        return this.repository.findById(PointsFidelityProgram.getId());
    }

    @Override
    public List<PointsFidelityProgram> getAll() {
        return this.repository.findAll();
    }

    @Override
    public PointsFidelityProgram update(@NonNull PointsFidelityProgram PointsFidelityProgram) {
        return this.repository.save(PointsFidelityProgram);
    }

    @Override
    public PointsFidelityProgram updateById(@NonNull Long id) {
        //TODO
        return null;
    }

    @Override
    public void delete(@NonNull PointsFidelityProgram PointsFidelityProgram) {
        this.repository.delete(PointsFidelityProgram);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }


    public void updateStatus(@NonNull Long digitalCardId, @NonNull Integer value){
        int points = findById(this.digitalCardService.findById(digitalCardId).getFidelityProgramId()).getConversionRate()*value;
        PointsDigitalCard pointsDigitalCard = this.digitalCardService.findById(digitalCardId);
        pointsDigitalCard.addPoints(points);
        this.digitalCardService.update(pointsDigitalCard);
    }

    public boolean redeemReward(@NonNull Long digitalCardId, @NonNull PointsReward pointsReward){
        if(findById(this.digitalCardService.findById(digitalCardId).getFidelityProgramId()).getCatalogue().contains(pointsReward)){
            if(this.digitalCardService.findById(digitalCardId).getPoints()>=pointsReward.getPrice()){
                PointsDigitalCard pointsDigitalCard = this.digitalCardService.findById(digitalCardId);
                pointsDigitalCard.removePoints(pointsReward.getPrice());
                pointsDigitalCard.addReward(pointsReward.getName());
                this.digitalCardService.update(pointsDigitalCard);
                return true;
            } else {
                return false;
            }
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Program doesn't contain this reward");
        }
    }
}
