package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

/**
 * Fidelity program based on levels
 */
@Getter
@Setter
@AllArgsConstructor
public class LevelFidelityProgram implements FidelityProgram {
    private static long idSaver = 0;
    private final @NonNull String name;
    private final long ref;
    private final @NonNull ArrayList<Client> clientsList;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private boolean activated = false;

    public LevelFidelityProgram(@NotNull String name, long ref) {
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
