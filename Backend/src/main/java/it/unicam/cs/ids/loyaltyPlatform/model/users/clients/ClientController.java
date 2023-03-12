package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.company.CompanyServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"}, maxAge = 3600)
@RestController
@RequestMapping(path = "loyaltyPlatform/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private FidelityProgramServiceImpl fidelityProgramService;
    @Autowired
    private CompanyServiceImpl companyService;

    @PostMapping(path = "/add")
    public Client add(@NonNull @RequestBody Client client) {
        return this.clientService.save(client);
    }

    @GetMapping(path = "/get/{clientId}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public Client get(@NonNull @PathVariable("clientId") Long clientId) {
        return this.clientService.findById(clientId);
    }

    @GetMapping(path = "/getAll")
    public List<Client> getAll(){
        return this.clientService.getAll();
    }

    @PutMapping(path = "/update/{client}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public Client update(@NonNull @RequestBody @PathVariable("client") Client client) {
        return this.clientService.update(client);
    }

    @PutMapping(path = "/update/profile/{clientId}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public Client updateProfile(@NonNull @RequestBody Client client, @NonNull @PathVariable("clientId") Long id) {
        return this.clientService.updateProfile(client, id);
    }
    @PutMapping(path = "/update/{clientId}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public Client update(@NonNull @RequestBody @PathVariable("clientId") Long id) {
        return this.clientService.updateById(id);
    }

    @PutMapping(path = "/registerToFidelityProgram/{clientId}/{fidelityProgramId}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public void registerToFidelityProgram(@NonNull @PathVariable("clientId") Long clientId, @NonNull @PathVariable Long fidelityProgramId){
        this.clientService.registerToFidelityProgram(this.clientService.findById(clientId),this.fidelityProgramService.findById(fidelityProgramId));
    }
    @PutMapping(path = "/getCompanies/{companyId}/getFidelityPrograms/{fidelityProgramId}/registerToFidelityProgram/{clientId}")
    public void registerToFidelityProgram(@NonNull @PathVariable("companyId") Long companyId, @NonNull @PathVariable("clientId") Long clientId, @NonNull @PathVariable("fidelityProgramId") Long fidelityProgramId){
         this.clientService.registerToFidelityProgram(this.companyService.findById(companyId), this.fidelityProgramService.findById(fidelityProgramId), this.clientService.findById(clientId));
    }

    @GetMapping(path = "/{clientId}/getDigitalWallet/{digitalWalletId}/getDigitalCard/{digitalCardId}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public DigitalCard viewDigitalCard(@NonNull @PathVariable("clientId") Long clientId, @NonNull @PathVariable("digitalWalletId") Long digitalWalletId, @NonNull @PathVariable("digitalCardId") Long digitalCardId){
        return this.clientService.viewDigitalCard(clientId,digitalWalletId,digitalCardId);
    }

    @DeleteMapping(path = "/delete/{clientId}")
    public void deleteById(@NonNull @PathVariable("clientId") Long clientId){
        this.clientService.deleteById(clientId);
    }
    @GetMapping(path = "/getDigitalCards/{clientId}")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public List<DigitalCard> getDigitalCards(@NonNull @PathVariable("clientId") Long clientId){
        return this.clientService.getDigitalCards(clientId);
    }
    @DeleteMapping(path = "/deleteAll")
    public void deleteAll(){
        this.clientService.deleteAll();
    }

}
