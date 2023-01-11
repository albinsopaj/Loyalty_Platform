package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.Client;
import lombok.*;

import java.util.ArrayList;

/**
 * Fidelity program based on levels
 */
@Getter
public class LevelFidelityProgram implements FidelityProgram {
    private @NonNull String name;
    private static @NonNull int id = 0;
    private @NonNull boolean activated = false;
    private @NonNull ArrayList<Client> clientsList;
    public LevelFidelityProgram(String name){
        this.name = name;
        id = id++;
        this.clientsList = new ArrayList<>();
    }

    @Override
    public void personalizeFidelityProgram() {
        //TODO
    }

    @Override
    public void activateFidelityProgram() {
        this.activated = true;
    }

    @Override
    public void deactivateFidelityProgram() {
        this.activated = false;
    }

    @Override
    public void resetFidelityProgram() {
        for(Client client: clientsList){
            //TODO reset client's digital card ??
        }
        this.clientsList.clear();
    }

    @Override
    public void addClient(Client client) {
        this.clientsList.add(client);
    }
}
