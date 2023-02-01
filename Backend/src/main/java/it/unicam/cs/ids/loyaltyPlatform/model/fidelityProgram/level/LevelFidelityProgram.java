package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;


import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
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

    private @NonNull Integer conversionRate;

    private @NonNull Integer experienceToUnlock;
    @OneToMany(mappedBy = "levelFidelityProgram")
    private @NonNull List<FidelityLevel> levels = new ArrayList<>();

    public void addFidelityLevel(FidelityLevel fidelityLevel){
        levels.add(fidelityLevel);
    }

    public void removeFidelityLevel(FidelityLevel fidelityLevel){
        levels.remove(fidelityLevel);
    }

}
