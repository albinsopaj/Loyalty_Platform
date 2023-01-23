package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
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

    public void createCampaign(@NonNull String name, String description) {
        //TODO
    }

    public void createFidelityProgram(String name, String description) {
        //TODO
    }

    public void createEmployee(String firstName, String lastName, String email, String phoneNumber, char gender, String domicile, Integer type, Company company) {
        //TODO
    }

}
