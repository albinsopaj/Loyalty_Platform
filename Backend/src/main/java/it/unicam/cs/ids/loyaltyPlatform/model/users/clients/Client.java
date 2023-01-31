package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramReview;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private @NonNull DigitalWallet digitalWallet;
    @ManyToMany(mappedBy = "likedFidelityPrograms")
    private @NonNull List<FidelityProgram> fidelityPrograms;

    @OneToMany(mappedBy = "client")
    private @NonNull Set<FidelityProgramReview> reviews;
    public Client createClient( String firstName, String lastName, String email, String phoneNumber, Character biologicalGender, String domicile){
        Client client = new Client();
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setBiologicalGender(biologicalGender);
        client.setDomicile(domicile);
        client.setFidelityPrograms(new ArrayList<>());
        client.setReviews(new HashSet<>());
        return client;
    }
    public void addReview( FidelityProgramReview review){
        reviews.add(review);
    }
    public void removeReview( FidelityProgramReview review){
        reviews.remove(review);
    }
    public void addFidelityProgram( FidelityProgram fidelityProgram){
        fidelityPrograms.add(fidelityProgram);
    }

    public void removeFidelityProgram( FidelityProgram fidelityProgram){
        fidelityPrograms.remove(fidelityProgram);
    }

}