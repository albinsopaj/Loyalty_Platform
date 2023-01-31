package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private FidelityProgramReviewKey id;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @MapsId("fidelityProgramId")
    @JoinColumn(name = "fidelityProgram_id")
    @JsonIgnore
    private FidelityProgram fidelityProgram;

    private @NonNull String review;

    private @NonNull Integer rating;

    public FidelityProgramReview(Client client, FidelityProgram fidelityProgram, String review, Integer rating){
        this.client = client;
        this.fidelityProgram = fidelityProgram;
        this.review = review;
        this.rating = rating;
    }

    public FidelityProgramReview createReview(Client client, FidelityProgram fidelityProgram, String review, Integer rating){
        FidelityProgramReview fidelityProgramReview = new FidelityProgramReview();
        fidelityProgramReview.setClient(client);
        fidelityProgramReview.setFidelityProgram(fidelityProgram);
        fidelityProgramReview.setReview(review);
        fidelityProgramReview.setRating(rating);
        return fidelityProgramReview;
    }
}
