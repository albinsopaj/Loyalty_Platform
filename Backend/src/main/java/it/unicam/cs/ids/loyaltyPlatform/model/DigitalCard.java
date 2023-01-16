package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class DigitalCard {
    @Id
    private int id;
    private @Setter
    @NonNull int points;
    private @NonNull
    @Getter
    @Setter String tierLevel;
    public DigitalCard(int id) {
        this.id = id;
    }

}
