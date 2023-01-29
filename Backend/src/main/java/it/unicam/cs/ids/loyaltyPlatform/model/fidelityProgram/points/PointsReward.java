package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

/**
 * Class that defines a reward that can be bought with points
 */
@AllArgsConstructor
@Getter
@Setter
@Entity
public class PointsReward {

    private @NonNull String name;
    private @NonNull Integer price;
}
