package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.Entity;
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

    private @NonNull Long companyId;

    /**
     * Method that updates the digital card of the client
     * @param digitalCard the digital card to update
     * @param value the amount spent by the client
     */
    public void updateClientDigitalCard(DigitalCard digitalCard, Integer value){
        digitalCard.updateStatus(value);
    }
    public void clientRegistration(String name, String surname, String email, String phoneNumber, char gender, String domicile) {
        //TODO implement
    }

    public DigitalCard retrieveDigitalCard(Long clientId, Long digitalCardId) {
        //TODO implement
        return null;
    }

    public FidelityProgram getFidelityProgram(Company company, Long fidelityProgramId) {
        //TODO implement
        return null;
    }

    public Client getClientProfile(DigitalCard digitalCard) {
        //TODO implement
        return null;
    }

    public void viewClientProfile() {
        String firstName = this.getFirstName();
        String lastName = this.getLastName();
        String email = this.getEmail();
        String phoneNumber = this.getPhoneNumber();
        Character biologicalGender = this.getBiologicalGender();
        String domicile = this.getDomicile();

    }

    public void updatePointsStatusManually() {
        //TODO
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
