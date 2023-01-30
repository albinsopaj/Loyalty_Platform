package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="FidelityProgramReview")
public class FidelityProgramReview {

    @EmbeddedId
    private @NonNull FidelityProgramReviewKey id;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private @NonNull Client client;

    @ManyToOne
    @MapsId("fidelityProgramId")
    @JoinColumn(name = "fidelityProgram_id")
    private @NonNull FidelityProgram fidelityProgram;

    private @NonNull String review;

    private @NonNull Integer rating;

}