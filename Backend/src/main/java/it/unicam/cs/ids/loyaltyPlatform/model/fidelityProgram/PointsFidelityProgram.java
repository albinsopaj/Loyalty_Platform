package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 * Fidelity program based on points
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class PointsFidelityProgram implements FidelityProgram {
    private @Id @NonNull UUID fidelityProgramId;
    private @NonNull String name;
    private boolean activated = false;
    private int rewardsNumber = 0;
    private @NonNull ArrayList<Client> clients;
    private @NonNull ArrayList<Map.Entry<String, Integer>> catalogue;

    public PointsFidelityProgram(@NotNull String name) {
        this.fidelityProgramId = UUID.randomUUID();
        this.name = name;
        this.clients = new ArrayList<>();
        this.catalogue = new ArrayList<>();
    }

    @Override
    public void personalizeFidelityProgram() {
        this.deactivateFidelityProgram();
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter number of rewards: ");
        this.rewardsNumber = reader.nextInt();
        int counter = this.rewardsNumber;
        String productName;
        int productCost;
        while(counter!=0){
            System.out.println("Enter name of the reward: ");
            productName = reader.nextLine();
            System.out.println("Enter cost of the reward: ");
            productCost = reader.nextInt();
            catalogue.add(new SimpleEntry<>(productName, productCost));
            counter--;
        }
        this.activateFidelityProgram();
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
