package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Class that defines the owner
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Owner")
public class Owner extends AuthenticatedUser {

    private @NonNull List<Long> companyIds;

    public void createCampaign(String name, Date start, Date end, String description) {
        //TODO
    }

    public void createFidelityProgram(String name, String description) {
        //TODO
    }

    public void createEmployee(String firstName, String lastName, String email, String phoneNumber, char gender, String domicile, Integer type, Company company) {
        //TODO
    }

}
