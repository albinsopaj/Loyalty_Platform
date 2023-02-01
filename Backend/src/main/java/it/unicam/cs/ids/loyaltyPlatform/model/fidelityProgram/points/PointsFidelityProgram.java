package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;


import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Fidelity program based on points
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name="pointsFidelityPrograms")
public class PointsFidelityProgram extends FidelityProgram {

    private @NonNull Integer conversionRate;

    @OneToMany(mappedBy = "pointsFidelityProgram")
    private List<PointsReward> catalogue;

    public void addReward(PointsReward pointsReward){
        catalogue.add(pointsReward);
    }

    public void removeReward(PointsReward pointsReward){
        catalogue.remove(pointsReward);
    }

    /*
    public void changeStatus(Integer value, DigitalCard digitalCard) {
        if(digitalCard instanceof PointsDigitalCard pointsDigitalCard){
            pointsDigitalCard.addPoints(valueConvert(value));
        } else {
            System.out.println("Error: this digital card isn't a points digital card");
        }
    }

    public void addReward(PointsReward pointsReward){
        this.catalogue.add(pointsReward);
    }


    private Integer valueConvert(Integer value){
        return value*conversionRate;
    }
    */
}
