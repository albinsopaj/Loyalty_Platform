package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import jakarta.persistence.*;
import lombok.*;

/**
 * Class that defines a digital card linked to a fidelity program and a digital wallet
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="digitalCard")
public abstract class DigitalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private @NonNull String fidelityProgramName;
    private @NonNull String companyName;
    private @NonNull Long fidelityProgramId;

    @ManyToOne
    @JoinColumn(name="digitalWallet_id",nullable=false)
    @JsonIgnore
    private @NonNull DigitalWallet digitalWallet;

    public DigitalCard(Long fidelityProgramId, DigitalWallet digitalWallet, String fidelityProgramName, String companyName){
        this.fidelityProgramId = fidelityProgramId;
        this.digitalWallet = digitalWallet;
        this.fidelityProgramName = fidelityProgramName;
        this.companyName = companyName;
    }
}
