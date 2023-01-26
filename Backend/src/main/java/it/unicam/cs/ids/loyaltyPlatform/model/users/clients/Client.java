package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalWallet;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * Class that defines a client of the platform
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Client extends AuthenticatedUser {

    private DigitalWallet digitalWallet;

    /**
     * Method to create a review and add it to the selected fidelity program
     * @param review the review wrote
     * @param fidelityProgram the selected fidelity program
     */
    public void createReview(String review, FidelityProgram fidelityProgram) {
        fidelityProgram.addReview(this, review);
    }

    public void subscribeToFidelityProgram(Company company) {
        //TODO implement
    }

    public String getProfile() {
        //TODO implement
        return null;
    }

    public void requestFidelityProgram() {
        //TODO

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Client client = (Client) o;
        return this.getId() != null && Objects.equals(this.getId(), client.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}