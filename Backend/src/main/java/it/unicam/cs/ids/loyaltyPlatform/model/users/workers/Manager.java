package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;

/**
 * Class that defines a manager
 */
public class Manager extends AuthenticatedUser {

    public Manager(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile) {
        super(name, surname, email, phoneNumber, biologicalGender, domicile);
    }
}
