package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Class that defines a client of the platform
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AuthenticatedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    public DigitalCard obtainDigitalCard() {
        //TODO
        return null;
    }

    public void requestFidelityProgram() {
        //TODO

    }

}