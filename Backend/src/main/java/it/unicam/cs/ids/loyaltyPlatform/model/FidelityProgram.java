package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class FidelityProgram {
    private @NonNull String nome;
    private @NonNull int id;
    private @NonNull Tipologia tipologia;

}
