package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import jakarta.persistence.*;
import lombok.*;

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
    private Long id;

    @ManyToOne
    @JoinColumn(name="company_id",nullable = false)
    @JsonIgnore
    private Company company;


    private @NonNull String name;
    private @NonNull String start;
    private @NonNull String end;
    private @NonNull String description;
}
