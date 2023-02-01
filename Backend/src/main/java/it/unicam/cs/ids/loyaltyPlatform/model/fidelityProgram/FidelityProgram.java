package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Set;

/**
 * Class that defines a general fidelity program
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "fidelityPrograms")
public abstract class FidelityProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private @NonNull Company company;

    private @NonNull String name;

    @ManyToMany
    @JoinTable(
            name = "fidelityProgram_like",
            joinColumns = @JoinColumn(name = "fidelityProgram_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    @JsonIgnore
    private List<Client> likedFidelityPrograms;

    @OneToMany(mappedBy = "fidelityProgram")
    private Set<FidelityProgramReview> reviews;

    public void addReview( FidelityProgramReview fidelityProgramReview){
        reviews.add(fidelityProgramReview);
    }
    public void removeReview( FidelityProgramReview fidelityProgramReview){
        reviews.remove(fidelityProgramReview);
    }
    public void addClient(Client client) {
        likedFidelityPrograms.add(client);
    }
    public void removeClient(Client client){
        likedFidelityPrograms.remove(client);
    }

}
