package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import lombok.Getter;
import lombok.Setter;

/**
 * Class that defines a client of the platform
 */
@Getter
@Setter
public class Client extends AuthenticatedUser {
    //TODO
    public Client(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile) {
        super();

        public DigitalCard obtainDigitalCard () {
            //TODO
            return null;
        }

        public void requestFidelityProgram () {
            //TODO
            super(name, surname, email, phoneNumber, biologicalGender, domicile);
        }
    }