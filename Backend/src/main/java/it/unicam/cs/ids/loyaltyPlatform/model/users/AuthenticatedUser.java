package it.unicam.cs.ids.loyaltyPlatform.model.users;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * AuthenticatedUser general class, it will be extended by the roles of the platform
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "authenticatedUsers")
public abstract class AuthenticatedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull Character biologicalGender;
    private @NonNull String domicile;

}
