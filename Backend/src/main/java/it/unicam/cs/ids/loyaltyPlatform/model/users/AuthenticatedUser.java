package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

/**
 * AuthenticatedUser general class, it will be extended by the roles of the platform
 */
@Getter
@Setter
public abstract class AuthenticatedUser implements AuthenticatedUserInterface {

    private @NonNull String name;
    private @NonNull String surname;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull Character biologicalGender;
    private @NonNull String domicile;
    private @NonNull String username;
    private @NonNull String password;
    private @NonNull long ref;
    public abstract AuthenticatedUser createNewAuthenticatedUser(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile);

    @Override
    public UUID getID() {
        return null;
    }
}
