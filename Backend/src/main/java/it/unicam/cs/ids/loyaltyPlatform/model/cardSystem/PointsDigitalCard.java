package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
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
    public void updateStatus(Integer value) {
        Company company = LoyaltyPlatform.getInstance().getCompany(getCompanyId());
        FidelityProgram fidelityProgram = company.getFidelityProgram(getFidelityProgramId());
        fidelityProgram.changeStatus(value, this);
    }

}
