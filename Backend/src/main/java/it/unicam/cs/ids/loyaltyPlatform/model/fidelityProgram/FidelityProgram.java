package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;

/**
 * Class that defines a general fidelity program
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "fidelityPrograms")
public abstract class FidelityProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;

    @ManyToOne
    @JoinColumn(name="company_id", nullable = false)
    private @NonNull Company company;

    private @NonNull String name;

    @ManyToMany
    @JoinTable(
            name = "fidelityProgram_like",
            joinColumns = @JoinColumn(name = "fidelityProgram_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private @NonNull List<Client> likedFidelityPrograms;
    /*
    @CollectionTable
    private @NonNull Map<Client,String> reviews;
    */

    public void addClient(Client client) {
        likedFidelityPrograms.add(client);
    }

    /**
     * Method to change the status of the digital card
     *
     * @param value       the amount of money
     * @param digitalCard the digital card to change
     */
    //public  void changeStatus(Integer value, DigitalCard digitalCard);

    /**
     * Method to add a review to the fidelity program
     * @param client the client writing the review
     * @param review the review to add
     */

    /*
    public void addReview(Client client, String review){
        this.addReview(client,review);
    }
    */
}
