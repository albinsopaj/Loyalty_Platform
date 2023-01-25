package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class LevelDigitalCard extends DigitalCard {

    private @NonNull Integer level;
    private @NonNull Integer experience;
    private @NonNull ArrayList<String> rewardsUnlocked;

    private @NonNull boolean completed;

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
