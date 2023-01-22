package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.lang.NonNull;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private @NonNull Long id;

    private @NonNull String name;
    private boolean activated = false;
    private int rewardsNumber = 0;
    private @NonNull List<Client> clients;
    private @NonNull List<Map.Entry<String, Integer>> catalogue;

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
        for (Client client : clients) {
            //TODO reset client's digital card ??
        }
        this.clients.clear();
    }

    @Override
    public void addClient(Client client) {
        this.clients.add(client);
    }

    @Override
    public Long getFidelityProgramId() {
        return this.id;
    }

}
