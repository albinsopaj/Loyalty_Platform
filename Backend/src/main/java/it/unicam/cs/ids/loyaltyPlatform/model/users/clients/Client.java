package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that defines a client of the platform
 */
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name="clients")
public class Client extends AuthenticatedUser {

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private DigitalWallet digitalWallet;

    @CollectionTable()
    private Set<Long> fidelityProgramIds = new HashSet<>();

    private String role = "ROLE_CLIENT";

    public void addFidelityProgram( Long fidelityProgramId){
        this.fidelityProgramIds.add(fidelityProgramId);
    }
    public void removeFidelityProgram( Long fidelityProgramId){
        this.fidelityProgramIds.remove(fidelityProgramId);
    }

}