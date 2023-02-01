package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

/**
 * Fidelity program based on levels
 */

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LevelDigitalCard extends DigitalCard {

    private Integer level = 0;
    private Integer experience = 0;
    @CollectionTable
    private @NonNull List<String> rewardsUnlocked;
    private boolean completed;

    public LevelDigitalCard(Long levelFidelityProgramId, DigitalWallet digitalWallet){
        super(levelFidelityProgramId,digitalWallet);
    }

    /**
     * Method to addOwner experience to the digital card
     *
     * @param experience the experience to addOwner
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
     * Method to addOwner the unlocked rewards
     *
     * @param rewards the rewards to addOwner
     */
    public void addRewards(List<String> rewards) {
        rewardsUnlocked.addAll(rewards);
    }

    public void removeRewards(List<String> rewards){
        rewardsUnlocked.removeAll(rewards);
    }
    /**
     * Method used to calculate if there is a level up
     */
    public void levelUp() {
        this.level++;
    }

}


