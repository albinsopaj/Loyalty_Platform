package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Fidelity program based on levels
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="levelFidelityProgram")
public class LevelFidelityProgram extends FidelityProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;
    private @NonNull Integer conversionRate;

    @OneToMany(mappedBy = "levelFidelityProgram")
    private @NonNull List<FidelityLevel> levels;

    public void addFidelityLevel(FidelityLevel fidelityLevel){
        levels.add(fidelityLevel);
    }

    public void removeFidelityLevel(FidelityLevel fidelityLevel){
        levels.remove(fidelityLevel);
    }

}
