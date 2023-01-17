package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

/**
 * Class that defines a client of the platform
 */
@Entity
@Getter
@Setter
public class Client extends AuthenticatedUser {
    private UUID id;

    @Id
    @GeneratedValue
    public @NonNull UUID getId() {
        return id;
    }

    public void setId(@NonNull UUID id) {
        this.id = id;
    }

    public DigitalCard obtainDigitalCard() {
        //TODO
        return null;
    }

    public void requestFidelityProgram() {
        //TODO
    }

    public DigitalCard viewDigitalCard() {
        //TODO
        return null;
    }

    @Override
    public AuthenticatedUser createNewAuthenticatedUser(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile) {
        //TODO
        return null;
    }
}