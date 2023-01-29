package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Fidelity program based on levels
 */
@Getter
@Setter
@Entity
public class LevelDigitalCard extends DigitalCard {

    private Integer level;
    private Integer experience;
    private @NonNull ArrayList<String> rewardsUnlocked;
    private boolean completed;

    public LevelDigitalCard(Long id, long companyId, Long fidelityProgramId, Long clientId, Integer level, Integer experience, ArrayList<String> rewardsUnlocked) {
        super(id, companyId, fidelityProgramId, clientId);
        this.level = level;
        this.experience = experience;
        this.rewardsUnlocked = rewardsUnlocked;
        this.completed = false;
    }

    /**
     * Method to add experience to the digital card
     * @param experience the experience to add
     */
    public void addExperience(Integer experience) {
        this.experience += experience;
    }

    /**
     * Method to remove experience to the digital card
     * @param experience the experience to remove
     */
    public void removeExperience(Integer experience){
        this.experience -= experience;
    }

    /**
     * Method to add the unlocked rewards
     * @param rewards the rewards to add
     */
    public void addRewards(ArrayList<String> rewards){
        rewardsUnlocked.addAll(rewards);
    }
    /**
     * Method used to calculate if there is a level up
     */
    public void levelUp() {
        this.level++;
    }

}
