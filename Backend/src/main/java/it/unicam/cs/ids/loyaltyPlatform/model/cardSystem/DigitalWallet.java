package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

/**
 * Class that defines a digital wallet linked to a client
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class DigitalWallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private @NonNull Long id;

    private @NonNull List<DigitalCard> digitalCards;

    /**
     * Method to add a digital card to the wallet
     *
     * @param digitalCard the digital card to add
     */
    public void addDigitalCard(@NonNull DigitalCard digitalCard) {
        Client client = new Client();
        this.digitalCards.add(digitalCard);
    }

    /**
     * Method to remove a digital card from the wallet
     *
     * @param digitalCardId the digital card's id to remove
     */
    public void removeDigitalCard(@NonNull Long digitalCardId) {
        this.digitalCards.removeIf(digitalCard -> digitalCard.getId().equals(digitalCardId));
    }
}
