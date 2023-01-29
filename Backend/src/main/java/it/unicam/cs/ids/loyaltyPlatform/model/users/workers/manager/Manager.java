package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * Class that defines a manager
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="managers")
public class Manager extends AuthenticatedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;
    @ManyToOne
    @JoinColumn(name="company_id",nullable = false)
    private @NonNull Company company;
    /**
     * Method to add a client into a fidelity program
     *
     * @param client          the client
     * @param fidelityProgram the fidelity program to add the client into
     */
    public void addClientToFidelityProgram(Client client, FidelityProgram fidelityProgram) {
        fidelityProgram.addClient(client);
    }

}
