package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public class Promozioni {

    private @NonNull final int  ultimiArrivi;
    private @NonNull final int sconti;

    public  Promozioni(@NonNull int ultimiArrivi,@NonNull int sconti){
        this.ultimiArrivi=ultimiArrivi;
        this.sconti=sconti;
    }

    }





