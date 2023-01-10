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
    private @Setter @NonNull int points;
    public DigitalCard(int id) {
        this.id = id;
    }

    public void setPoints(int points){
        this.points = points;
    }
    public int getId() {
        return id;
    }


}
