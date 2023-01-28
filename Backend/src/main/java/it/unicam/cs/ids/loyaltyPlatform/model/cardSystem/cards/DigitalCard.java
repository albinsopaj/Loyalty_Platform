package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
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
@AllArgsConstructor
@NoArgsConstructor
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
    public void updateStatus(Integer value) {
        Company company = LoyaltyPlatform.getInstance().getCompany(getCompanyId());
        FidelityProgram fidelityProgram = company.getFidelityProgram(getFidelityProgramId());
        fidelityProgram.changeStatus(value, this);
    }
}
