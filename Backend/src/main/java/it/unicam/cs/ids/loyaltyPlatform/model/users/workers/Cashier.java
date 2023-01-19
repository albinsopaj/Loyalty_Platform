package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Class that defines a cashier
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cashier extends AuthenticatedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private @NonNull UUID id;

    public void viewClientProfile() {
        //TODO
    }

    public void updatePointsStatusManually() {
        //TODO
    }

    public void scanQrCode() {
        //TODO
    }

}
