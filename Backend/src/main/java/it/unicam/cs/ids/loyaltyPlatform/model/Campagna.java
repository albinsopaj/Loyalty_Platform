package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Campagna {

    private @NonNull String nome;
    private @NonNull int id;
    private @NonNull Date inizio;
    private @NonNull Date fine;

}
