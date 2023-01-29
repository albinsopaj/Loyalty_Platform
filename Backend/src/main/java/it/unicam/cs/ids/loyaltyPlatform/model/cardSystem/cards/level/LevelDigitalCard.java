package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;

/**
 * Fidelity program based on levels
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LevelDigitalCard extends DigitalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;
    private Integer level;
    private Integer experience;
    @CollectionTable
    private @NonNull ArrayList<String> rewardsUnlocked;
    private boolean completed;

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


