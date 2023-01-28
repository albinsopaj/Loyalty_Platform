package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import lombok.NonNull;
import java.util.List;
import java.util.Optional;

public interface FidelityProgramService {

    FidelityProgram saveById(@NonNull Long id);

    FidelityProgram findById(@NonNull Long id);

    Optional<FidelityProgram> get(@NonNull FidelityProgram fidelityProgram);

    List<FidelityProgram> getAll();

    FidelityProgram update(@NonNull FidelityProgram fidelityProgram);

    FidelityProgram updateById(@NonNull Long id);

    void delete(@NonNull FidelityProgram fidelityProgram);

    void deleteById(@NonNull Long id);

}
