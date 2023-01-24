package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Fidelity program based on levels
 */
@AllArgsConstructor
@Getter
@Setter
public class LevelFidelityProgram extends FidelityProgram {


    @Override
    public void changeStatus(Integer value, DigitalCard digitalCard) {

    }

}
