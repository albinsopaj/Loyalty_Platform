package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

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

    private @NonNull Long clientId;
    private @NonNull List<DigitalCard> digitalCards;

//    public void addDigitalCard(DigitalCard digitalCard) {
//        if (!this.digitalCards.contains(digitalCard)) {
//            this.digitalCards.add(digitalCard);
//        }
//    }

//    public void removeDigitalCard(Long digitalCardId) {
//        this.digitalCards.removeIf(digitalCard -> digitalCard.getId().equals(digitalCardId));
//    }

}
