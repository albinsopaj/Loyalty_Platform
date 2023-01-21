package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Class that defines a campaign
 */
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Component
@Getter
@Setter
@ToString
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private @NonNull UUID id;
    private @NonNull String name;
    private @NonNull Date start;
    private @NonNull Date end;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(id, campaign.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
