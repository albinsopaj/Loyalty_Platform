package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Campaign {

    private @NonNull String name;
    private @NonNull int id;
    private @NonNull Date start;
    private @NonNull Date end;

}
