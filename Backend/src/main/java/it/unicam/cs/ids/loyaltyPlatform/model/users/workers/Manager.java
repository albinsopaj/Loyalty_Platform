package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

/**
 * Class that defines a manager
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Manager extends AuthenticatedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", null able = false)
    private UUID id;

}
