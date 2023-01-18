package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.util.UUID;


/**
 * Class that defines a digital card linked to a fidelity program and a digital wallet
 */
@Getter
@Setter
public class DigitalCard {

    private final @Id @NonNull UUID digitalCardId;

    public DigitalCard(){
        this.digitalCardId = UUID.randomUUID();
    }
}
