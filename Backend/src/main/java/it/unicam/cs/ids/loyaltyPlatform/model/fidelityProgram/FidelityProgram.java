package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.lang.NonNull;
import java.util.HashMap;
import java.util.List;

/**
 * Class that defines a general fidelity program
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public abstract class FidelityProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private @NonNull Long id;

    private @NonNull String name;
    private @NonNull List<Client> clients;
    private @NonNull Boolean activated = false;
    private @NonNull HashMap<Client,String> reviews;
    /**
     * Activates the fidelity program
     *
     */
    public void activateFidelityProgram(){
        this.activated = true;
    }

    /**
     * Deactivates the fidelity program
     *
     */
    public void deactivateFidelityProgram(){
        this.activated = false;
    }

    /**
     * Resets a fidelity program, this means that every client's progress using that program will be resetted
     *
     */
    public void resetFidelityProgram(){
        this.clients.clear();
    }

    /**
     * Adds a client to the fidelity program
     *
     * @param client the client to addCampaign
     */
    public abstract void addClient(Client client);

    /**
     * Method to change the status of the digital card
     * @param value the amount of money
     * @param digitalCard the digital card to change
     */
    public abstract void changeStatus(Integer value, DigitalCard digitalCard);

    /**
     * Method to add a review to the fidelity program
     * @param client the client writing the review
     * @param review the review to add
     */
    public void addReview(Client client, String review){
        this.addReview(client,review);
    }
}
