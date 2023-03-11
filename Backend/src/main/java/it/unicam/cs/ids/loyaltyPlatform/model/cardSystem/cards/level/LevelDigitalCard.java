package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.level;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;
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
    private String type = "Levels";
    private Integer level = 0;
    private Integer experience = 0;
    @CollectionTable
    private @NonNull List<String> rewardsUnlocked = new ArrayList<>();

    public LevelDigitalCard(Long levelFidelityProgramId, DigitalWallet digitalWallet, String fidelityProgramName, String companyName){
        super(levelFidelityProgramId,digitalWallet,fidelityProgramName,companyName);
    }

    public void addExperience(Integer experience) {
        this.experience += experience;
    }

    public void removeExperience(Integer experience){
        this.experience -= experience;
    }

    public void addRewards(List<String> rewards) {
        rewardsUnlocked.addAll(rewards);
    }

    public void removeRewards(List<String> rewards){
        rewardsUnlocked.removeAll(rewards);
    }

    public void levelUp() {
        this.level++;
    }

}


