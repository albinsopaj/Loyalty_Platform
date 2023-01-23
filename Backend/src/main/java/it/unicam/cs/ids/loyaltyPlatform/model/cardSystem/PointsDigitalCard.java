package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.platform.LoyaltyPlatform;
import jakarta.persistence.Entity;
import lombok.*;

/**
 * Class that defines a digital card of a points based fidelity program
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class PointsDigitalCard extends DigitalCard {

    private @NonNull Integer points;
    @Override
    public void updateStatus(LoyaltyPlatform platform, Integer value) {
        platform.getCompanies().get(value).getFidelityProgram(getFidelityProgramId());
        //TODO
    }
}
