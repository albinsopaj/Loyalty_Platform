package it.unicam.cs.ids.loyaltyPlatform.model.marketingModule;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import jakarta.persistence.*;
import lombok.*;

/**
 * Class that defines a marketing module in the platform
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "marketingModules")
public class MarketingModule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name="company_id")
    private @NonNull Company company;

    private @NonNull String name;


    /*
    public void updateDigitalCardStatus(DigitalCard digitalCard, Integer value){
        digitalCard.updateStatus(value);
    }
    */
}
