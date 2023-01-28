package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import java.util.ArrayList;

/**
 * Class that defines a level inside a fidelityProgram
 */
@AllArgsConstructor
@Getter
@Setter
public class FidelityLevel {
    private @NonNull String name;
    private @NonNull ArrayList<String> rewardsList;

    private @NonNull Integer experienceToUnlock;

    /**
     * Method to add a reward to the list of rewards
     * @param reward the reward to add
     */
    public void addReward(String reward){
        this.rewardsList.add(reward);
    }
}
