package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.PointsReward;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;

/**
 * Class that defines a digital card of a points based fidelity program
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
public class PointsDigitalCard extends DigitalCard {

    private @NonNull int points;

    private @NonNull ArrayList<PointsReward> rewards;

    private @NonNull boolean completed;

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
        rewards.remove(reward);
        if(rewards.isEmpty()){
            this.completed = true;
        }
    }
}
