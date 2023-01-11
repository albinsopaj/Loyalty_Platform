package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

/**
 * Factory method class for fidelity programs
 */
public class FidelityProgramFactory {
    /**
     * Factory method for fidelity programs
     * @param fidelityProgramTypeName name of the type of fidelity program to create
     * @param name of the fidelity program
     * @return fidelityProgram of the correct type
     */
    public FidelityProgram getFidelityProgram(String fidelityProgramTypeName, String name ){
        if(fidelityProgramTypeName == null){
            return null;
        }
        if(fidelityProgramTypeName.equalsIgnoreCase("Points")){
            return new PointsFidelityProgram(name);
        } else {
            return new LevelFidelityProgram(name);
        }
    }
}
