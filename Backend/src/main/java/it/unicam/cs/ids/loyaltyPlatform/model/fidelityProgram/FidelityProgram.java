package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;

/**
 * Interface that defines fidelity programs
 */
public interface FidelityProgram {

    /**
     * Personalizes a fidelity program
     */
    void personalizeFidelityProgram();

    /**
     * Activates the fidelity program
     *
     */
    void activateFidelityProgram();

    /**
     * Deactivates the fidelity program
     *
     */
    void deactivateFidelityProgram();

    /**
     * Resets a fidelity program, this means that every client's progress using that program will be resetted
     *
     */
    void resetFidelityProgram();

    /**
     * Adds a client to the fidelity program
     *
     * @param client the client to addCampaign
     */
    void addClient(Client client);

    long getId();

}
