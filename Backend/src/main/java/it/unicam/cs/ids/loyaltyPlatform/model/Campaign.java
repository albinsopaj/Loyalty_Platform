package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {

    private @NonNull String name;
    private @NonNull @Id int id;
    private @NonNull Date start;
    private @NonNull Date end;
    private @NonNull long ref;

}
