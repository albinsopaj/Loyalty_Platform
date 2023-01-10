package it.unicam.cs.ids.loyaltyPlatform.model;

/**
    Interface that defines fidelity programs

 */
public interface FidelityProgram {

    /**
     * Creates a fidelity program given name and description, the program will not be activated until personalized
     *
     * @param name of the fidelity program
     * @param description of the fidelity program
     */
    void createFidelityProgram(String name, String description);

    /**
     * Personalizes a fidelity program
     *
     * @param name of the fidelity program to personalize
     */
    void personalizeFidelityProgram(String name);

    /**
     * Activates the fidelity program
     *
     * @param name of the fidelity program to activate
     */
    void activateFidelityProgram(String name);

    /**
     * Deactivates the fidelity program
     *
     * @param name of the fidelity program to deactivate
     */
    void deactivateFidelityProgram(String name);

    /**
     * Resets a fidelity program, this means that every client's progress using that program will be resetted
     *
     * @param name of the fidelity program to reset
     */
    void resetFidelityProgram(String name);
}
