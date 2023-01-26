package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem;

import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DigitalCardService {
    
    DigitalCard save(@NonNull DigitalCard digitalCard);

    DigitalCard saveById(@NonNull Long id);

    DigitalCard findById(@NonNull Long id);

    List<DigitalCard> getAll();

    DigitalCard update(DigitalCard digitalCard);

    DigitalCard updateById(@NonNull Long id);

    void delete(@NonNull DigitalCard digitalCard);

    void deleteById(@NonNull Long id);

}
