package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;

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

    private @NonNull ArrayList<Long> companyIds;

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
