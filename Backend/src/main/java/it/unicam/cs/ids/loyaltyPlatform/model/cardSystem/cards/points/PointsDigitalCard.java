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
    private @NonNull Integer points;

    @CollectionTable
    private @NonNull ArrayList<String> rewards;

    private boolean completed;

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

    @Override
    public DigitalCard create() {
        return new PointsDigitalCard();
    }

    /*
    public void buyReward(PointsReward reward){
        removePoints(reward.getPrice());
        rewards.add(reward.getName());
        if(rewards.isEmpty()){
            this.completed = true;
        }
    }

    */
}
