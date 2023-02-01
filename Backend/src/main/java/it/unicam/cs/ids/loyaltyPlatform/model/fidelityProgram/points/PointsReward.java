package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

/**
 * Class that defines a reward that can be bought with points
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="pointsReward")
public class PointsReward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="pointsFidelityProgram_id")
    @JsonIgnore
    private PointsFidelityProgram pointsFidelityProgram;

    private @NonNull String name;
    private @NonNull Integer price;

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof PointsReward pointsReward)){
            return false;
        }
        return pointsReward.name.equals(name) && pointsReward.price.equals(price);
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
