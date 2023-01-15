package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

/**
 * Fidelity program based on levels
 */
@Getter
public class LevelFidelityProgram implements FidelityProgram {
    private @NonNull String name;
    private static @NonNull long idSaver = 0;
    private @NonNull @Id long id;
    private @NonNull long ref;
    private @NonNull boolean activated = false;
    private @NonNull ArrayList<Client> clientsList;
    public LevelFidelityProgram(String name, long ref){
        this.name = name;
        this.id = LevelFidelityProgram.getNextRefId();
        this.ref = ref;
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

    /**
     * Calculates next unique refId
     * @return the next unique refId
     */
    public static long getNextRefId(){
        long id = idSaver;
        idSaver++;
        return id;
    }
}
