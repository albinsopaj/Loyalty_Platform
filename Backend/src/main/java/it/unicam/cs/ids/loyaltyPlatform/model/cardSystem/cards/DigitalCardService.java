package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface DigitalCardService<T extends DigitalCard> {
    T save(@NonNull T digitalCard);

    T saveById(@NonNull Long id);

    T update(@NonNull T digitalCard);

    T updateById(@NonNull Long id);

    T findById(@NonNull Long id);

    Optional<T> get(@NonNull T digitalCard);

    List<T> getAll();

    void delete(@NonNull T digitalCard);

    void delete(@NonNull Long id);
}
