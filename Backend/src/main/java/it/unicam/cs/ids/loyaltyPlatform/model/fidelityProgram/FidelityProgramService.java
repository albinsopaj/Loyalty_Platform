package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import lombok.NonNull;
import java.util.List;
import java.util.Optional;

public interface FidelityProgramService<T extends FidelityProgram> {

    T save(@NonNull T fidelityProgram);

    T saveById(@NonNull Long id);

    T update(@NonNull T fidelityProgram);

    T updateById(@NonNull Long id);

    T findById(@NonNull Long id);

    Optional<T> get(@NonNull T fidelityProgram);

    List<T> getAll();

    void delete(@NonNull T fidelityProgram);

    void delete(@NonNull Long id);

}
