package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that defines a digital card of a points based fidelity program
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PointsDigitalCard extends DigitalCard {
    private @NonNull Integer points = 0;

    @CollectionTable
    private @NonNull List<String> rewards;

    public PointsDigitalCard(Long pointsFidelityProgramId, DigitalWallet digitalWallet){
        super(pointsFidelityProgramId,digitalWallet);
        this.rewards = new ArrayList<>();
    }
    public void addReward(String reward){
        rewards.add(reward);
    }

    public void removeReward(String reward){
        rewards.remove(reward);
    }

    public void addPoints(int points) {
        this.points += points;
    }


    public void removePoints(int points) {
        this.points -= points;
    }

}
