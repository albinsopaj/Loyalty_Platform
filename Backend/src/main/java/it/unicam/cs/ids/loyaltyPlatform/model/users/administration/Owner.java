package it.unicam.cs.ids.loyaltyPlatform.model.users.administration;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.PointsFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import java.util.UUID;

/**
 * Class that defines the owner
 */
public class Owner extends AuthenticatedUser {

    public void createCampaign(PointsFidelityProgram fidelityProgram) {

    }

    public void createNewFidelityProgram() {

    }

    public void createNewRole() {

    }

    @Override
    public AuthenticatedUser createNewAuthenticatedUser(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile) {
        //TODO
        return null;
    }

    @Override
    public UUID getID() {
        return null;
    }
}
