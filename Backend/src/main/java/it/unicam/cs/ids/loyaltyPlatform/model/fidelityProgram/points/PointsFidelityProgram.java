package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points.PointsDigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
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
@Entity
@Table(name="pointsFidelityPrograms")
public class PointsFidelityProgram extends FidelityProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @lombok.NonNull Long id;
    private @NonNull Integer conversionRate;

    @OneToMany(mappedBy = "pointsFidelityProgram")
    private @NonNull ArrayList<PointsReward> catalogue;



    public void changeStatus(Integer value, DigitalCard digitalCard) {
        if(digitalCard instanceof PointsDigitalCard pointsDigitalCard){
            pointsDigitalCard.addPoints(valueConvert(value));
        } else {
            System.out.println("Error: this digital card isn't a points digital card");
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
