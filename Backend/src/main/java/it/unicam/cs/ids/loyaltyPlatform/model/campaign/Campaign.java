package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name="company_id",nullable = false)
    private @NonNull Company company;
    private @NonNull String name;
    private @NonNull Date start;
    private @NonNull Date end;
    private @NonNull String description;


}
