package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;


import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level.LevelDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level.LevelDigitalCardServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class LevelFidelityProgramServiceImpl implements GeneralService<LevelFidelityProgram> {
    @Autowired
    private LevelFidelityProgramRepository repository;
    @Autowired
    private LevelDigitalCardServiceImpl digitalCardService;
    @Override
    public LevelFidelityProgram save(@NonNull LevelFidelityProgram fidelityProgram) {
        if (!repository.findAll().contains(fidelityProgram)) {
            return this.repository.save(fidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.FOUND, "Fidelity program already exists");
        }
    }

    @Override
    public LevelFidelityProgram findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fidelity program not found"));
    }

    @Override
    public Optional<LevelFidelityProgram> get(@NonNull LevelFidelityProgram levelFidelityProgram) {
        return this.repository.findById(levelFidelityProgram.getId());
    }

    @Override
    public List<LevelFidelityProgram> getAll() {
        return this.repository.findAll();
    }

    @Override
    public LevelFidelityProgram update(@NonNull LevelFidelityProgram levelFidelityProgram) {
        return this.repository.save(levelFidelityProgram);
    }

    @Override
    public LevelFidelityProgram updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull LevelFidelityProgram levelFidelityProgram) {
        this.repository.delete(levelFidelityProgram);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    public void updateStatus(@NonNull Long digitalCardId, @NonNull Integer value){
        int experience = findById(this.digitalCardService.findById(digitalCardId).getFidelityProgramId()).getConversionRate()*value;
        LevelDigitalCard levelDigitalCard = this.digitalCardService.findById(digitalCardId);
        LevelFidelityProgram fidelityProgram = findById(this.digitalCardService.findById(digitalCardId).getFidelityProgramId());
        levelDigitalCard.addExperience(experience);
        while(levelDigitalCard.getExperience()>=fidelityProgram.getExperienceToUnlock()){
            Integer currentLevel = levelDigitalCard.getLevel();
            levelDigitalCard.addRewards(fidelityProgram.getLevels().get(currentLevel).getRewardsList());
            levelDigitalCard.removeExperience(fidelityProgram.getExperienceToUnlock());
            levelDigitalCard.levelUp();
        }
        this.digitalCardService.update(levelDigitalCard);
    }

}
