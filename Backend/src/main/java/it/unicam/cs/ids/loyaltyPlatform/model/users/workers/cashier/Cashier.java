package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;

/**
 * Class that defines a cashier
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name="cashiers")
public class Cashier extends AuthenticatedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;

    @ManyToOne
    @JoinColumn(name="company_id", nullable = false)
    private @NonNull Company company;

}
