package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.ClientController;
import org.jetbrains.annotations.NotNull;

/**
 * Class that defines a cashier
 */
public class Cashier extends AuthenticatedUser {

    private ClientController controller;

    public Cashier(@NotNull String name, @NotNull String surname, @NotNull String email, @NotNull String phoneNumber, @NotNull Character biologicalGender, @NotNull String domicile) {
        super(name, surname, email, phoneNumber, biologicalGender, domicile);
    }

    public void viewClientProfile() {

    }

    public void updatePointsStatusManually() {
        this.controller.
    }

    public void scanQrCode() {

    }

}
