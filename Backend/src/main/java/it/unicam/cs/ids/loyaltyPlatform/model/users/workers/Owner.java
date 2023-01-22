package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.PointsFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;

/**
 * Class that defines the owner
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
public class Owner extends AuthenticatedUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private @NonNull Long id;

    public void createCampaign(@NonNull PointsFidelityProgram fidelityProgram) {
        //TODO
    }

    public void createNewFidelityProgram() {
        //TODO
    }

    public void createNewRole() {
        //TODO
    }

}
