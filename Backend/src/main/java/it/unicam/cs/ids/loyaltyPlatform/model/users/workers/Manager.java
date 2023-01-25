package it.unicam.cs.ids.loyaltyPlatform.model.users.workers;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.*;

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

    private Long companyId;

    /**
     * Method to add a client into a fidelity program
     * @param client the client
     * @param fidelityProgram the fidelity program to add the client into
     */
    public void addClientToFidelityProgram(Client client, FidelityProgram fidelityProgram) {
        fidelityProgram.addClient(client);
    }

}
