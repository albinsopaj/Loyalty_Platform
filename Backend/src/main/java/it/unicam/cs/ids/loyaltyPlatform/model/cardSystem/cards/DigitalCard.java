package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards;

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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="digitalCard")
public abstract class DigitalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;

    private @NonNull Long fidelityProgramId;

    @ManyToOne
    @JoinColumn(name="digitalWallet_id",nullable=false)
    private @NonNull DigitalWallet digitalWallet;

}
