package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * AuthenticatedUser general class, it will be extended by the roles of the platform
 */
@Getter
@Setter
public abstract class AuthenticatedUser {

    private final @Id @NonNull UUID userId;
    private @NonNull String name;
    private @NonNull String surname;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull Character biologicalGender;
    private @NonNull String domicile;

    public AuthenticatedUser(@NotNull String name, @NotNull String surname, @NotNull String email, @NotNull String phoneNumber, @NotNull Character biologicalGender, @NotNull String domicile) {
        this.userId = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.biologicalGender = biologicalGender;
        this.domicile = domicile;
    }

    public abstract AuthenticatedUser createNewAuthenticatedUser(String name, String surname, String email, String phoneNumber, Character biologicalGender, String domicile);
}
