package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Fidelity program based on levels
 */
@Getter
@Setter
@AllArgsConstructor
public class LevelFidelityProgram implements FidelityProgram {
    private final @Id @NonNull UUID fidelityProgramId;
    private final @NonNull String name;
    private final @NonNull ArrayList<Client> clients;
    private boolean activated = false;

    public LevelFidelityProgram(@NotNull String name) {
        this.fidelityProgramId = UUID.randomUUID();
        this.name = name;
        this.clients = new ArrayList<>();
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
        for(Client client: clients){
            //TODO reset client's digital card ??
        }
        this.clients.clear();
    }
    @Override
    public void addClient(Client client) {
        this.clients.add(client);
    }
}
