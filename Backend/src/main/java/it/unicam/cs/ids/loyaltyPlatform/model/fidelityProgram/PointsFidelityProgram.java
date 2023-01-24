package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.PointsDigitalCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

/**
 * Fidelity program based on points
 */
@AllArgsConstructor
@Getter
@Setter
public class PointsFidelityProgram extends FidelityProgram {

    private @NonNull Integer conversionRate;

    @Override
    public void personalizeFidelityProgram() {

    }

    @Override
    public void changeStatus(Integer value, DigitalCard digitalCard) {
        if(digitalCard instanceof PointsDigitalCard pointsDigitalCard){
            pointsDigitalCard.setPoints(valueConvert(value));
        } else {
            System.out.println("Error, this digital card isn't a points digital card");
        }
    }

    private Integer valueConvert(Integer value){
        return value*conversionRate;
    }

}
