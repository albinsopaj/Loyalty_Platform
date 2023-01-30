package it.unicam.cs.ids.loyaltyPlatform.model.company;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.marketingModule.MarketingModule;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier.Cashier;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.Manager;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner.Owner;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;

import java.util.List;
import java.util.Objects;

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
    private @NonNull Owner owner;

    @OneToMany(mappedBy = "company")
    private @NonNull List<FidelityProgram> fidelityPrograms;
    @OneToMany(mappedBy = "company")
    private @NonNull List<Campaign> campaigns;
    @OneToMany(mappedBy = "company")
    private @NonNull List<Manager> managers;
    @OneToMany(mappedBy = "company")
    private @NonNull List<Cashier> cashiers;
    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private @NonNull MarketingModule marketingModule;


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
    /*
    public void removeFidelityProgram(@NonNull Long fidelityProgramId) {
        this.fidelityPrograms.removeIf(fidelityProgram -> fidelityProgram.getId().equals(fidelityProgramId));
    }


    public void removeCampaign(@NonNull Long campaignId) {
        this.campaigns.removeIf(campaign -> campaign.getId().equals(campaignId));
    }


    public void removeManager(@NonNull Long userId) {
        this.managers.removeIf(manager -> manager.getId().equals(userId));
    }


    public void removeCashier(@NonNull Long userId) {
        this.cashiers.removeIf(cashier -> cashier.getId().equals(userId));
    }

    public FidelityProgram getFidelityProgram(@NonNull Long fidelityProgramId) {
        for (FidelityProgram fidelityProgram : fidelityPrograms) {
            if (fidelityProgram.getId().equals(fidelityProgramId)) {
                return fidelityProgram;
            }
        }
        throw new ObjectNotFoundException(fidelityProgramId, "Fidelity Program not present");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Company company = (Company) o;
        return id != null && Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    */
}
