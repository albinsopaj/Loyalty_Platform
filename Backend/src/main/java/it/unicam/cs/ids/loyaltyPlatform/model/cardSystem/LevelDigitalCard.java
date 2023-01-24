package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.LevelFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.platform.LoyaltyPlatform;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

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

    /**
     * Method to add experience to the digital card
     * @param experience the experience to add
     */
    public void addExperience(Integer experience) {
        this.experience += experience;
        levelUp();
    }

    /**
     * Method used to calculate if there is a level up
     */
    private void levelUp() {
        Company company = LoyaltyPlatform.getInstance().getCompany(getCompanyId());
        FidelityProgram fidelityProgram = company.getFidelityProgram(getFidelityProgramId());
        if(fidelityProgram instanceof LevelFidelityProgram levelFidelityProgram){
            //TODO
        }
    }
}
