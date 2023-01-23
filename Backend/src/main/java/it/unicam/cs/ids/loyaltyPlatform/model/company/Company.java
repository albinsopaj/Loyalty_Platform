package it.unicam.cs.ids.loyaltyPlatform.model.company;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.Cashier;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.Manager;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.Owner;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

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
@Entity(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "", nullable = false)
    private Long id;

    private @NonNull String name;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private @NonNull Owner owner;

    @Transient
    private @NonNull List<FidelityProgram> fidelityPrograms;
    @Transient
    private @NonNull List<Campaign> campaigns;
    @Transient
    private @NonNull List<Manager> managers;
    @Transient
    private @NonNull List<Cashier> cashiers;

    /**
     * Method to add a fidelity program to the company
     *
     * @param fidelityProgram the fidelity program to add
     */
    public void addFidelityProgram(@NonNull FidelityProgram fidelityProgram) {
        this.fidelityPrograms.add(fidelityProgram);
    }

    /**
     * Method to add a campaign to the company
     *
     * @param campaign the campaign to add
     */
    public void addCampaign(@NonNull Campaign campaign) {
        this.campaigns.add(campaign);
    }

    /**
     * Method to add a manager to the company
     *
     * @param manager the manager to add
     */
    public void addManager(@NonNull Manager manager) {
        this.managers.add(manager);
    }

    /**
     * Method to add a cashier to the company
     *
     * @param cashier the cashier to add
     */
    public void addCashier(@NonNull Cashier cashier) {
        this.cashiers.add(cashier);
    }

    /**
     * Method to remove a fidelity program from the company
     *
     * @param fidelityProgramId the fidelity program's id
     */
    public void removeFidelityProgram(@NonNull Long fidelityProgramId) {
        this.fidelityPrograms.removeIf(fidelityProgram -> fidelityProgram.getFidelityProgramId().equals(fidelityProgramId));
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
     * returns the fidelity program with the specified id
     * @param fidelityProgramId the specified id
     */
    public FidelityProgram getFidelityProgram( Long fidelityProgramId){
        for(FidelityProgram fidelityProgram: fidelityPrograms){
            if(fidelityProgram.getFidelityProgramId().equals(fidelityProgramId)){
                return fidelityProgram;
            }
        }
        return null;
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
