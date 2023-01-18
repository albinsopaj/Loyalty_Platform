package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;

/**
 * Class that defines the owner
 */
public class Owner extends AuthenticatedUser {
    //TODO
    public Owner(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile) {
        super(name, surname, email, phoneNumber, biologicalGender, domicile);
    }
}
