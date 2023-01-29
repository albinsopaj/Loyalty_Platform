package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points;

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
    private @NonNull Long id;

    @ManyToOne
    @JoinColumn(name="pointsFidelityProgram_id", nullable = false)
    private @NonNull PointsFidelityProgram pointsFidelityProgram;
    private @NonNull String name;
    private @NonNull Integer price;
}
