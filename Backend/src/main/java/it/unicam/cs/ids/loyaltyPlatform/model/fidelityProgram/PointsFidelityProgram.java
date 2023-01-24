package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.PointsDigitalCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import java.util.ArrayList;

/**
 * Fidelity program based on points
 */
@AllArgsConstructor
@Getter
@Setter
public class PointsFidelityProgram extends FidelityProgram {

    private @NonNull Integer conversionRate;

    private @NonNull ArrayList<PointsReward> catalogue;

    @Override
    public void changeStatus(Integer value, DigitalCard digitalCard) {
        if(digitalCard instanceof PointsDigitalCard pointsDigitalCard){
            pointsDigitalCard.setPoints(valueConvert(value));
        } else {
            System.out.println("Error, this digital card isn't a points digital card");
        }
    }

    /**
     * Method to add a reward to the fidelity program
     * @param pointsReward the reward to add
     */
    public void addReward(PointsReward pointsReward){
        this.catalogue.add(pointsReward);
    }
    private Integer valueConvert(Integer value){
        return value*conversionRate;
    }

}
