package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;


import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
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
    private @NonNull List<PointsReward> catalogue = new ArrayList<>();

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

    */
}
