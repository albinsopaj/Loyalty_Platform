package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Class that defines a digital wallet linked to a client
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="digitalWallets")
public class DigitalWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;
    @OneToMany(mappedBy = "digitalWallet")
    private @NonNull List<DigitalCard> digitalCards;

    public DigitalWallet(Client client){
        this.client = client;
    }

    public void addDigitalCard(DigitalCard digitalCard){
        digitalCards.add(digitalCard);
    }

    public void removeDigitalCard(DigitalCard digitalCard){
        digitalCards.remove(digitalCard);
    }

    public void removeDigitalCard(FidelityProgram fidelityProgram){
        Long fidelityProgramId = fidelityProgram.getId();
        for(DigitalCard digitalCard: digitalCards){
            if(digitalCard.getFidelityProgramId().equals(fidelityProgramId)){
                removeDigitalCard(digitalCard);
            }
        }
    }

    public DigitalCard getDigitalCard(FidelityProgram fidelityProgram){
        Long fidelityProgramId = fidelityProgram.getId();
        for(DigitalCard digitalCard: digitalCards){
            if(digitalCard.getFidelityProgramId().equals(fidelityProgramId)){
                return digitalCard;
            }
        }
        throw new IllegalArgumentException("Card doesn't exist");
    }

}
