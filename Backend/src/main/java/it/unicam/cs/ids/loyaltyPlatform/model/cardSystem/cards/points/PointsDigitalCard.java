package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsReward;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

/**
 * Class that defines a digital card of a points based fidelity program
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PointsDigitalCard extends DigitalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;
    private @NonNull Integer points;

    @CollectionTable
    private @NonNull ArrayList<String> rewards;

    private boolean completed;

    /**
     * Method to add points to the digital card
     * @param points the points to add
     */
    public void addPoints(int points) {
        this.points += points;
    }

    /**
     * Method to remove points to the digital card
     * @param points the points to remove
     */
    public void removePoints(int points) {
        this.points -= points;
    }

    /**
     * Method that removes a reward and spends the points to do so
     * @param reward the reward to "buy"
     */
    public void buyReward(PointsReward reward){
        removePoints(reward.getPrice());
        rewards.add(reward.getName());
        if(rewards.isEmpty()){
            this.completed = true;
        }
    }
}
