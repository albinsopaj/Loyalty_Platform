package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.HashSet;
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

    @CollectionTable
    private @NonNull Set<Long> clientIds = new HashSet<>();
    @OneToMany(mappedBy = "fidelityProgram")
    private @NonNull Set<FidelityProgramReview> reviews = new HashSet<>();

    public void addReview( FidelityProgramReview fidelityProgramReview){
        reviews.add(fidelityProgramReview);
    }
    public void removeReview( FidelityProgramReview fidelityProgramReview){
        reviews.remove(fidelityProgramReview);
    }
    public void addClient(Long clientId) {
        clientIds.add(clientId);
    }
    public void removeClient(Long clientId){
        clientIds.remove(clientId);
    }

}
