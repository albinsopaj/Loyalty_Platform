package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DigitalCardService {

    DigitalCard saveById(@NonNull Long id);

    DigitalCard findById(@NonNull Long id);

    List<DigitalCard> getAll();

    DigitalCard update(DigitalCard digitalCard);

    DigitalCard updateById(@NonNull Long id);

    void delete(@NonNull DigitalCard digitalCard);

    void deleteById(@NonNull Long id);

}
