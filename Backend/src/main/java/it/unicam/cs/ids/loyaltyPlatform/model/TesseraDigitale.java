package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class TesseraDigitale {
    @Id
    private int id;
    private @Setter @NonNull int punti;
    public TesseraDigitale(int id) {
        this.id = id;
    }

    public void setPunti(int punteggio){
        this.punti = punteggio;
    }
    public int getId() {
        return id;
    }


}
