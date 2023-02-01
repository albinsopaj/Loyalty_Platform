package it.unicam.cs.ids.loyaltyPlatform.model.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.marketingModule.MarketingModule;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier.Cashier;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.Manager;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner.Owner;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Class that defines a company in the platform
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private @NonNull String name;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonIgnore
    private Owner owner;

    @OneToMany(mappedBy = "company")
    private List<FidelityProgram> fidelityPrograms;
    @OneToMany(mappedBy = "company")
    private List<Campaign> campaigns;
    @OneToMany(mappedBy = "company")
    private List<Manager> managers;
    @OneToMany(mappedBy = "company")
    private List<Cashier> cashiers;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private MarketingModule marketingModule;


    public void addFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        fidelityPrograms.add(fidelityProgram);
    }

    public void addCampaign(@NonNull Campaign campaign) {
        campaigns.add(campaign);
    }

    public void addManager(@NonNull Manager manager) {
        managers.add(manager);
    }

    public void addCashier(@NonNull Cashier cashier) {
        cashiers.add(cashier);
    }

    public void removeFidelityProgram(@NonNull FidelityProgram fidelityProgram){
        fidelityPrograms.remove(fidelityProgram);
    }

    public void removeCampaign(@NonNull Campaign campaign){
        campaigns.remove(campaign);
    }

    public void removeManager(@NonNull Manager manager){
        managers.remove(manager);
    }

    public void removeCashier(@NonNull Cashier cashier){
        cashiers.remove(cashier);
    }

}
