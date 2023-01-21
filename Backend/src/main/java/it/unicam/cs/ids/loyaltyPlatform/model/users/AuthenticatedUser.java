package it.unicam.cs.ids.loyaltyPlatform.model.users;

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

    //private final @Id @NonNull UUID userId; >> Servira' avere una chiave primaria per l'AuthenticatedUser come classe astratta
    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull Character biologicalGender;
    private @NonNull String domicile;

    //di sotto si possono aggiungere eventuali metodi che si ritengono utili

}
