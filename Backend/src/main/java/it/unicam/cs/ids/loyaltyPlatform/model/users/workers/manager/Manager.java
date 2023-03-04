package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;

/**
 * Class that defines a manager
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="managers")
public class Manager extends AuthenticatedUser {

    @ManyToOne
    @JoinColumn(name="company_id",nullable = false)
    @JsonIgnore
    private @NonNull Company company;

    private @NonNull String role = "ROLE_MANAGER";
}
