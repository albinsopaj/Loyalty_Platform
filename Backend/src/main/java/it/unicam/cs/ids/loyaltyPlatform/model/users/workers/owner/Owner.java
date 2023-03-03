package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "owners")
public class Owner extends AuthenticatedUser {

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private @NonNull List<Company> companies = new ArrayList<>();

    private @NonNull String role = "owner";

   public void addCompany( Company company){
       companies.add(company);
    }

    public void removeCompany( Company company){
        companies.remove(company);
    }
}
