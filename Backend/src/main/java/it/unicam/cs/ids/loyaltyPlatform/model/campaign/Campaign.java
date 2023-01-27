package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

/**
 * Class that defines a campaign
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;

    private @NonNull String name;
    private @NonNull Date start;
    private @NonNull Date end;
    private @NonNull String description;

}
