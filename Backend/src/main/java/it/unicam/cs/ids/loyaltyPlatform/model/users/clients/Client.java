package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;

/**
 * Class that defines a client of the platform
 */
public class Client extends AuthenticatedUser {

    @Override
    public AuthenticatedUser createNewAuthenticatedUser(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile) {
        //TODO
        return null;
    }

    public void loginUser(){
        //TODO
    }

    public DigitalCard obtainDigitalCard(){
        //TODO
        return null;
    }

    public void requestFidelityProgram(){
        //TODO
    }

    public DigitalCard viewDigitalCard(){
        //TODO
        return null;
    }
}