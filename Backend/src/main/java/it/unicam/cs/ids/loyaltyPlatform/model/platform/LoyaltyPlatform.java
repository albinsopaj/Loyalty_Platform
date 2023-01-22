package it.unicam.cs.ids.loyaltyPlatform.model.platform;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Class that defines the loyalty platform
 */
@Getter
@AllArgsConstructor
public class LoyaltyPlatform {

    private @NonNull String name;
    private @NonNull List<Company> companies;
    private @NonNull List<Client> clients;

    /**
     * Method to add client to the platform
     *
     * @param client the client to add
     */
    public void addClient(@NonNull Client client) {
        this.clients.add(client);
    }

    /**
     * Method to add company to the platform
     *
     * @param company the company to add
     */
    public void addCompany(@NonNull Company company) {
        this.companies.add(company);
    }

    /**
     * Method to remove a client from the platform
     *
     * @param userId the client's id to remove
     */
    public void removeClient(@NonNull Long userId) {
        this.clients.removeIf(client -> client.getId().equals(userId));
    }

    /**
     * Method to remove a company from the platform
     *
     * @param id the company's id to remove
     */
    public void removeCompany(@NonNull Long id) {
        this.companies.removeIf(company -> company.getId().equals(id));
    }
}
