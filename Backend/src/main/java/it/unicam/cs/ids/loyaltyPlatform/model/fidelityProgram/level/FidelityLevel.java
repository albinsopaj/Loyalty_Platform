package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Class that defines a level inside a fidelityProgram
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class FidelityLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;

    private @NonNull String name;
    @CollectionTable
    private @NonNull List<String> rewardsList;

    @ManyToOne
    @JoinColumn(name="levelFidelityProgram_id")
    @JsonIgnore
    private LevelFidelityProgram levelFidelityProgram;

    public void addReward(String reward) {
        this.rewardsList.add(reward);
    }

    public void removeReward(String reward){ this.rewardsList.remove(reward);}
}
