package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;

/**
 * Class that defines a cashier
 */
public class Cashier extends AuthenticatedUser {

    public void viewClientProfile() {

    }

    public void updatePointsStatusManually() {

    }

    public void scanQrCode() {

    }

    @Override
    public AuthenticatedUser createNewAuthenticatedUser(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile) {
        //TODO
        return null;
    }

}
