package it.unicam.cs.ids.loyaltyPlatform.model.users;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

/**
 * AuthenticatedUser general class, it will be extended by the roles of the platform
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@EqualsAndHashCode
public abstract class AuthenticatedUser {

    private @Id
    @NonNull Long userId; // --> Servira' avere una chiave primaria per l'AuthenticatedUser come classe astratta ???
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull Character biologicalGender;
    private @NonNull String domicile;

}
