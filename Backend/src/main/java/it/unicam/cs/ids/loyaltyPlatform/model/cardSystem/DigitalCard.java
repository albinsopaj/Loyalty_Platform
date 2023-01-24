package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import it.unicam.cs.ids.loyaltyPlatform.model.platform.LoyaltyPlatform;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * Class that defines a digital card linked to a fidelity program and a digital wallet
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public abstract class DigitalCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private @NonNull Long id;

    private @NonNull Long companyId;
    private @NonNull Long fidelityProgramId;
    private @NonNull Long clientId;

    /**
     * Method to update the status of a digital card based on the amount of money spent
     * @param value the money amount
     */
    public abstract void updateStatus(Integer value);

}
