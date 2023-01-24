package it.unicam.cs.ids.loyaltyPlatform.model.marketingModule;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.platform.LoyaltyPlatform;
import jakarta.persistence.*;
import lombok.*;

/**
 * Class that defines a marketing module in the platform
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "MarketingModule")
public class MarketingModule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "", nullable = false)
    private Long id;

    private @NonNull Long companyId;

    private @NonNull String name;

    /**
     * Method to update the status of a digital card given the amount spent
     * @param digitalCard the client digital card
     * @param value the amount spent
     */
    public void updateDigitalCardStatus(DigitalCard digitalCard, Integer value){
        digitalCard.updateStatus(value);
    }

}
