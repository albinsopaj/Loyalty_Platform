package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Objects;

/**
 * Class that defines a cashier
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Cashier extends AuthenticatedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private @NonNull Long id;

    /**
     * Method that updates the digital card of the client
     *
     * @param digitalCard the digital card to update
     * @param value       the amount spent by the client
     */
    public void updateClientDigitalCard(DigitalCard digitalCard, Integer value) {
        digitalCard.updateStatus(value);
    }

    public void viewClientProfile() {
        String firstName = this.getFirstName();
        String lastName = this.getLastName();
        String email = this.getEmail();
        String phoneNumber = this.getPhoneNumber();
        Character biologicalGender = this.getBiologicalGender();
        String domicile = this.getDomicile();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cashier cashier = (Cashier) o;
        return Objects.equals(this.getId(), cashier.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
