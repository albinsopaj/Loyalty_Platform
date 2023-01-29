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

    /**
     * Method to add a fidelity program to the company
     *
     * @param fidelityProgram the fidelity program to add
     */
    public void addFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        if (!this.fidelityPrograms.contains(fidelityProgram)) {
            this.fidelityPrograms.add(fidelityProgram);
        }
    }

    /**
     * Method to add a campaign to the company
     *
     * @param campaign the campaign to add
     */
    public void addCampaign(@NonNull Campaign campaign) {
        if (!this.campaigns.contains(campaign)) {
            this.campaigns.add(campaign);
        }
    }

    /**
     * Method to add a manager to the company
     *
     * @param manager the manager to add
     */
    public void addManager(@NonNull Manager manager) {
        if (!this.managers.contains(manager)) {
            this.managers.add(manager);
        }
    }

    /**
     * Method to add a cashier to the company
     *
     * @param cashier the cashier to add
     */
    public void addCashier(@NonNull Cashier cashier) {
        if (!this.cashiers.contains(cashier)) {
            this.cashiers.add(cashier);
        }
    }

    /**
     * Method to remove a fidelity program from the company
     *
     * @param fidelityProgramId the fidelity program's id
     */
    public void removeFidelityProgram(@NonNull Long fidelityProgramId) {
        this.fidelityPrograms.removeIf(fidelityProgram -> fidelityProgram.getId().equals(fidelityProgramId));
    }

    /**
     * Method to remove a campaign from the company
     *
     * @param campaignId the campaign's id
     */
    public void removeCampaign(@NonNull Long campaignId) {
        this.campaigns.removeIf(campaign -> campaign.getId().equals(campaignId));
    }

    /**
     * Method to remove a manager from the company
     *
     * @param userId the manager's id
     */
    public void removeManager(@NonNull Long userId) {
        this.managers.removeIf(manager -> manager.getId().equals(userId));
    }

    /**
     * Method to remove a cashier from the company
     *
     * @param userId the cashier's id
     */
    public void removeCashier(@NonNull Long userId) {
        this.cashiers.removeIf(cashier -> cashier.getId().equals(userId));
    }

    /**
     * Returns the fidelity program with the specified id
     *
     * @param fidelityProgramId the specified id
     */
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
}
