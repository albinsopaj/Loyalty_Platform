package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="FidelityProgramReview")
public class FidelityProgramReview {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    */
    @EmbeddedId
    @JsonIgnore
    private FidelityProgramReviewKey id;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    @JsonIgnore
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
    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof FidelityProgramReview fidelityProgramReview)){
            return false;
        }
        return fidelityProgramReview.client.equals(client) && fidelityProgramReview.fidelityProgram.equals(fidelityProgram);
    }
    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + client.hashCode();
        result = 31 * result + fidelityProgram.hashCode();
        return result;
    }

}
