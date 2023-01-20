package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * Class that defines a campaign
 */
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Component
@Data
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private @NonNull UUID id;
    private @NonNull String name;
    private @NonNull Date start;
    private @NonNull Date end;

    public Campaign(@NonNull String name, @NonNull Date start, @NonNull Date end) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.start = start;
        this.end = end;
    }

}
