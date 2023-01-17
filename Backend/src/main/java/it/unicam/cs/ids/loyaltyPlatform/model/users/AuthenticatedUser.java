package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * AuthenticatedUser general class, it will be extended by the roles of the platform
 */
@Getter
@Setter
public abstract class AuthenticatedUser {
    @Id
    private @NonNull long id;
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull Character biologicalGender;
    private @NonNull String domicile;
    private @NonNull String username;
    private @NonNull String password;
    private long ref;

    public abstract AuthenticatedUser createNewAuthenticatedUser(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile);

}
