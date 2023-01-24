package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import it.unicam.cs.ids.loyaltyPlatform.model.platform.LoyaltyPlatform;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Class that defines a digital card of a points based fidelity program
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class PointsDigitalCard extends DigitalCard {

    private int points = 0;

    public void addPoints(int points) {
        this.points += points;
    }

    public void removePoints(int points) {
        this.points -= points;
    }

    @Override
    public void updateStatus(LoyaltyPlatform platform, Integer value) {
        platform.getCompanies().get(value).getFidelityProgram(getFidelityProgramId());
        //TODO
    }

}
