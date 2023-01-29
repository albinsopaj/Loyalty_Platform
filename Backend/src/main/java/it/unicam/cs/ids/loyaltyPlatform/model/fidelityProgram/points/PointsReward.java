package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

/**
 * Class that defines a reward that can be bought with points
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PointsReward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @lombok.NonNull Long id;

    private @NonNull String name;
    private @NonNull Integer price;
}
