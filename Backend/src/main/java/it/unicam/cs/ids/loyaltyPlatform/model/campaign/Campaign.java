package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * Class that defines a campaign
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Getter
@Setter
@ToString
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private @NonNull Long id;
    private @NonNull String name;
    private @NonNull Date start;
    private @NonNull Date end;
    private @NonNull String description;

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
