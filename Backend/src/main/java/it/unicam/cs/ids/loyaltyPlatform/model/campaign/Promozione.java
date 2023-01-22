package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Promozione {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int ultimiArrivi;
    private int sconti;

    public Promozione(int ultimiArrivi, int sconti) {
        this.ultimiArrivi = ultimiArrivi;
        this.sconti = sconti;
    }

    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }


}





