package it.unicam.cs.ids.loyaltyPlatform.model;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;

/**
 * Class that defines a loyalty platform
 */
@Getter
@AllArgsConstructor
public class LoyaltyPlatform {
    private @NonNull String name;
    private @NonNull ArrayList<FidelityProgram> fidelityPrograms;
    private @NonNull ArrayList<Campaign> campaigns;
    private @NonNull ArrayList<AuthenticatedUser> authenticatedUsers;

    /**
     * Add method for fidelity programs
     *
     * @param fidelityProgram the fidelity program to addCampaign
     */
    public void addFidelityProgram(FidelityProgram fidelityProgram) {
        fidelityPrograms.add(fidelityProgram);
    }

    /**
     * Add method for campaigns
     *
     * @param campaign the campaign to addCampaign
     */
    public void addCampaign(Campaign campaign) {
        campaigns.add(campaign);
    }

    /**
     * Add method for authenticated users
     *
     * @param authenticatedUser the authenticated user to addCampaign
     */
    public void addAuthenticatedUser(AuthenticatedUser authenticatedUser){
        authenticatedUsers.add(authenticatedUser);
    }

    /**
     * Remove method for fidelity programs
     * @param id the id of the fidelity program to remove
     */
    public void removeFidelityProgram(long id){
        fidelityPrograms.remove(id);
    }

    /**
     * Remove method for campaigns
     * @param id the id of the campaign to remove
     */
    public void removeCampaign(long id){
        campaigns.remove(id);
    }

    public void removeAuthenticatedUser(){
        //TODO
    }
}
