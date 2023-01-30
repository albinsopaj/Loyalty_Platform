package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

/**
 * Class that defines the owner
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="owners")
public class Owner extends AuthenticatedUser {

    @OneToMany(mappedBy = "owner")
    private @NonNull ArrayList<Company> companies;

    public void addCompany( Company company){
        companies.add(company);
    }

    public void removeCompany( Company company){
        companies.remove(company);
    }
}
