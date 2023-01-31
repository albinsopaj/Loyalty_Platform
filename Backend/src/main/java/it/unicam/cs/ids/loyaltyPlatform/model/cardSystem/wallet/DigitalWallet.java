package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    private @NonNull Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "client_id")
    private @NonNull Client client;
    @OneToMany(mappedBy = "digitalWallet")
    private @NonNull List<DigitalCard> digitalCards;

    public DigitalWallet createDigitalWallet(Client client){
        DigitalWallet digitalWallet = new DigitalWallet();
        digitalWallet.setClient(client);
        digitalWallet.setDigitalCards(new ArrayList<>());
        return digitalWallet;
    }
    public void addDigitalCard(DigitalCard digitalCard){
        digitalCards.add(digitalCard);
    }

    public void removeDigitalCard(DigitalCard digitalCard){
        digitalCards.remove(digitalCard);
    }
}
