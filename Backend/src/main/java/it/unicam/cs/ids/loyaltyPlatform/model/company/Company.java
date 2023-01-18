package it.unicam.cs.ids.loyaltyPlatform.model.company;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.Cashier;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.Manager;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.Owner;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Class that defines a company in the platform
 */
@Getter
@Setter
public class Company {
    private @Id @NonNull UUID companyId;
    private @NonNull String name;
    private @NonNull Owner owner;
    private @NonNull ArrayList<FidelityProgram> fidelityPrograms;
    private @NonNull ArrayList<Campaign> campaigns;
    private @NonNull ArrayList<Manager> managers;
    private @NonNull ArrayList<Cashier> cashiers;

    public Company(@NotNull String name, @NotNull Owner owner) {
        this.companyId = UUID.randomUUID();
        this.name = name;
        this.owner = owner;
        this.fidelityPrograms = new ArrayList<>();
        this.campaigns = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.cashiers = new ArrayList<>();
    }

    /**
     * Method to add a fidelity program to the company
     * @param fidelityProgram the fidelity program to add
     */
    public void addFidelityProgram(FidelityProgram fidelityProgram){
        this.fidelityPrograms.add(fidelityProgram);
    }

    /**
     * Method to add a campaign to the company
     * @param campaign the campaign to add
     */
    public void addCampaign(Campaign campaign){
        this.campaigns.add(campaign);
    }

    /**
     * Method to add a manager to the company
     * @param manager the manager to add
     */
    public void addManager(Manager manager){
        this.managers.add(manager);
    }

    /**
     * Method to add a cashier to the company
     * @param cashier the cashier to add
     */
    public void addCashier(Cashier cashier){
        this.cashiers.add(cashier);
    }

    /**
     * Method to remove a fidelity program from the company
     * @param fidelityProgramId the fidelity program's id
     */
    public void removeFidelityProgram(UUID fidelityProgramId){
        this.fidelityPrograms.removeIf(fidelityProgram -> fidelityProgram.getFidelityProgramId().equals(fidelityProgramId));
    }

    /**
     * Method to remove a campaign from the company
     * @param campaignId the campaign's id
     */
    public void removeCampaign(UUID campaignId){
        this.campaigns.removeIf(campaign -> campaign.getCampaignId().equals(campaignId));
    }

    /**
     * Method to remove a manager from the company
     * @param userId the manager's id
     */
    public void removeManager(UUID userId){
        this.managers.removeIf(manager -> manager.getUserId().equals(userId));
    }

    /**
     * Method to remove a cashier from the company
     * @param userId the cashier's id
     */
    public void removeCashier(UUID userId){
        this.cashiers.removeIf(cashier -> cashier.getUserId().equals(userId));
    }
}
