package it.unicam.cs.ids.loyaltyPlatform.model.platform;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that defines the loyalty platform
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoyaltyPlatform {

    private static LoyaltyPlatform instance = null;

    private @NonNull String name;
    private @NonNull List<Company> companies;
    private @NonNull List<Client> clients;

    /**
     * Method to add client to the platform
     *
     * @param client the client to add
     */
    public void addClient(@NonNull Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }

    /**
     * Method to add company to the platform
     *
     * @param company the company to add
     */
    public void addCompany(@NonNull Company company) {
        if (!companies.contains(company)) {
            companies.add(company);
        }
    }

    /**
     * Method to remove a client from the platform
     *
     * @param clientId the client's id to remove
     */
    public void removeClient(@NonNull Long clientId) {
        clients.removeIf(client -> client.getId().equals(clientId));
    }

    /**
     * Method to remove a company from the platform
     *
     * @param id the company's id to remove
     */
    public void removeCompany(@NonNull Long id) {
        companies.removeIf(company -> company.getId().equals(id));
    }

    public Client getClient(@NonNull long clientId){
        for(Client client: clients){
            if(client.getUserId().equals(clientId)){
                return client;
            }
        }
        return null;
    }

    public Company getCompany(@NonNull long companyId){
        for(Company company: companies){
            if(company.getId().equals(companyId)){
                return company;
            }
        }
        return null;
    }

    public static LoyaltyPlatform getInstance(){
        if(instance == null){
            instance = new LoyaltyPlatform();
        }
        return instance;
    }
}
