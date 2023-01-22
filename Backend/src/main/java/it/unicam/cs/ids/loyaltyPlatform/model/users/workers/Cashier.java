package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Class that defines a cashier
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cashier extends AuthenticatedUser {

    @Id
    @Column(name = "id", nullable = false)
    private @NonNull Long id;

    public void viewClientProfile() {
        String firstName = this.getFirstName();
        String lastName = this.getLastName();
        String email=this.getEmail();
        String phoneNumber = this.getPhoneNumber();
        Character biologicalGender = this.getBiologicalGender();
        String domicile = this.getDomicile();

    }

    public void updatePointsStatusManually() {
        //TODO
    }

    public void scanQrCode() {
        //TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cashier cashier = (Cashier) o;
        return Objects.equals(id, cashier.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
