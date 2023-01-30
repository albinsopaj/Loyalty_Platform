package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

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
@Embeddable
@Entity
public class FidelityLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;

    private @NonNull String name;
    @CollectionTable
    private @NonNull List<String> rewardsList;

    private @NonNull Integer experienceToUnlock;

    /**
     * Method to add a reward to the list of rewards
     * @param reward the reward to add
     */
    public void addReward(String reward){
        this.rewardsList.add(reward);
    }

}
