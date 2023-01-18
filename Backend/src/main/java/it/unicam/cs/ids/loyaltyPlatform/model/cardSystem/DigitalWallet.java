package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Class that defines a digital wallet linked to a client
 */
@Getter
@Setter
public class DigitalWallet {

    private final @Id @NonNull UUID digitalWalletId;
    private @NonNull ArrayList<DigitalCard> digitalCards;
    public DigitalWallet(){
        this.digitalWalletId = UUID.randomUUID();
        this.digitalCards = new ArrayList<>();
    }

    /**
     * Method to add a digital card to the wallet
     * @param digitalCard the digital card to add
     */
    public void addDigitalCard(DigitalCard digitalCard){
        Client client = new Client();
        this.digitalCards.add(digitalCard);
    }

    /**
     * Method to remove a digital card from the wallet
     * @param digitalCardId the digital card's id to remove
     */
    public void removeDigitalCard(UUID digitalCardId){
        this.digitalCards.removeIf(digitalCard -> digitalCard.getDigitalCardId().equals(digitalCardId));
    }
}
