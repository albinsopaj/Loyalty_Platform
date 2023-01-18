package it.unicam.cs.ids.loyaltyPlatform.model.platform;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Class that defines the loyalty platform
 */
@Getter
@AllArgsConstructor
public class LoyaltyPlatform {
    private @NonNull String name;
    private @NonNull ArrayList<Client> clients;
    private @NonNull ArrayList<Company> companies;

    /**
     * Method to add client to the platform
     * @param client the client to add
     */
    public void addClient(Client client){
        this.clients.add(client);
    }

    /**
     * Method to add company to the platform
     * @param company the company to add
     */
    public void addCompany(Company company){
        this.companies.add(company);
    }

    /**
     * Method to remove a client from the platform
     * @param userId the client's id to remove
     */
    public void removeClient(UUID userId){
        this.clients.removeIf(client -> client.getUserId().equals(userId));
    }

    /**
     * Method to remove a company from the platform
     * @param companyId the company's id to remove
     */
    public void removeCompany(UUID companyId){
        this.companies.removeIf(company -> company.getCompanyId().equals(companyId));
    }
}
