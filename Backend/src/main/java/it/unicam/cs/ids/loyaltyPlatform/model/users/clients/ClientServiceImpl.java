package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWalletServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.*;
import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements GeneralService<Client> {

    @Autowired
    private ClientRepository repository;
    @Autowired
    private DigitalCardServiceImpl digitalCardService;
    @Autowired
    private DigitalWalletServiceImpl digitalWalletService;
    @Autowired
    private FidelityProgramServiceImpl fidelityProgramService;

    public Client save(@NonNull Client client) {
        if (!repository.findAll().contains(client)) {
            this.digitalWalletService.save(new DigitalWallet(client));
            return this.repository.save(client);
        } else throw new ResponseStatusException(HttpStatus.FOUND, "Client already exists");
    }

    @Override
    public Client findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    public Client updateProfile(@NonNull Client client, Long id) {
        Client newClient = findById(id);
        newClient.setFirstName(client.getFirstName());
        newClient.setLastName(client.getLastName());
        newClient.setEmail(client.getEmail());
        newClient.setPhoneNumber(client.getPhoneNumber());
        newClient.setBiologicalGender(client.getBiologicalGender());
        newClient.setDomicile(client.getDomicile());
        newClient.setUsername(client.getUsername());
        return this.repository.save(newClient);
    }
    @Override
    public Optional<Client> get(@NonNull Client client) {
        return this.repository.findById(client.getId());
    }

    @Override
    public List<Client> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Client update(@NonNull Client client) {
        return this.repository.save(client);
    }

    @Override
    public Client updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    @Override
    public void delete(@NonNull Client client) {
        this.repository.delete(client);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

    public void registerToFidelityProgram(@NonNull Company company, @NonNull FidelityProgram fidelityProgram, @NonNull Client client){
        if(company.getFidelityPrograms().contains(fidelityProgram)){
            this.fidelityProgramService.registerClient(client, fidelityProgram);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Company doesn't own this fidelity program");
        }
    }

    public DigitalCard viewDigitalCard(@NonNull Long clientId, @NonNull Long digitalWalletId, @NonNull Long digitalCardId){
        if(this.repository.getReferenceById(clientId).getDigitalWallet().getId().equals(digitalWalletId) && this.digitalWalletService.findById(digitalWalletId).getDigitalCards().contains(this.digitalCardService.findById(digitalCardId))){
            return this.digitalCardService.findById(digitalCardId);
        } else {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Client doesn't have access to this resource");
        }
    }

    public void deleteAll(){
        this.repository.deleteAll();
    }

    public void removeFidelityProgramSubscription(Long clientId, Long fidelityProgramId){
        Client client = findById(clientId);
        client.getFidelityProgramIds().remove(fidelityProgramId);
        FidelityProgram fidelityProgram = this.fidelityProgramService.findById(fidelityProgramId);
        fidelityProgram.removeClient(client.getId());
        this.digitalCardService.delete(client.getDigitalWallet().getDigitalCard(fidelityProgram));
    }
}
