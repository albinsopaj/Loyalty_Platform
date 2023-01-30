package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import jakarta.persistence.Embeddable;
import lombok.*;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FidelityProgramReviewKey implements Serializable {

    private @NonNull Long clientId;
    private @NonNull Long fidelityProgramId;
}
