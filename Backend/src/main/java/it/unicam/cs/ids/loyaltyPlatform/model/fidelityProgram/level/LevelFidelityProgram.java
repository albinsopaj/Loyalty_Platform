package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level.LevelDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

/**
 * Fidelity program based on levels
 */
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="levelFidelityProgram")
public class LevelFidelityProgram extends FidelityProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;
    private @NonNull Integer conversionRate;
    @ElementCollection
    @Embedded
    private @NonNull List<FidelityLevel> levels;

    public void changeStatus(Integer value, DigitalCard digitalCard) {
        if(digitalCard instanceof LevelDigitalCard levelDigitalCard){
            updateDigitalCardStatus(valueConvert(value), levelDigitalCard);
        } else {
            System.out.println("Error: this digital card isn't a level digital card");
        }
    }
    private void updateDigitalCardStatus(Integer experience, LevelDigitalCard levelDigitalCard){
        if(!levelDigitalCard.isCompleted()){
            levelDigitalCard.addExperience(experience);
            int nextLevel = levelDigitalCard.getLevel() + 1;
            while(levelDigitalCard.getExperience()>=levels.get(nextLevel).getExperienceToUnlock()){
                levelDigitalCard.levelUp();
                levelDigitalCard.removeExperience(levels.get(nextLevel).getExperienceToUnlock());
                levelDigitalCard.addRewards(levels.get(levelDigitalCard.getLevel()).getRewardsList());
                nextLevel++;
                if(levels.size()<nextLevel){
                    levelDigitalCard.setCompleted(true);
                    break;
                }
            }
        } else {
            System.out.println("Digital Card completed");
        }
    }

    private Integer valueConvert(Integer value){
        return value*conversionRate;
    }
}