package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import jakarta.persistence.*;
import lombok.*;
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

    public void addClient(Long clientId) {
        clientIds.add(clientId);
    }
    public void removeClient(Long clientId){
        clientIds.remove(clientId);
    }

}
