package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Class that defines a client of the platform
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name="clients")
public class Client extends AuthenticatedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private @NonNull DigitalWallet digitalWallet;
    @ManyToMany(mappedBy = "likedFidelityPrograms")
    private @NonNull List<FidelityProgram> fidelityPrograms;
    /**
     * Method to create a review and add it to the selected fidelity program
     *
     * @param review          the review wrote
     * @param fidelityProgram the selected fidelity program
     */

    /*
    public void createReview(String review, FidelityProgram fidelityProgram) {
        fidelityProgram.addReview(this, review);
    }
    */
}