package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.company.CompanyServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/client")
@CrossOrigin("http://localhost:3000/")
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
    public Client get(@NonNull @PathVariable("clientId") Long clientId) {
        return this.clientService.findById(clientId);
    }

    @GetMapping(path = "/getAll")
    public List<Client> getAll(){
        return this.clientService.getAll();
    }

    @PutMapping(path = "/update/{client}")
    public Client update(@NonNull @RequestBody @PathVariable("client") Client client) {
        return this.clientService.update(client);
    }

    @PutMapping(path = "/update/{clientId}")
    public Client update(@NonNull @RequestBody @PathVariable("clientId") Long id) {
        return this.clientService.updateById(id);
    }

    @PutMapping(path = "/getCompanies/{companyId}/getFidelityPrograms/{fidelityProgramId}/registerToFidelityProgram/{clientId}")
    public void registerToFidelityProgram(@NonNull @PathVariable("companyId") Long companyId, @NonNull @PathVariable("clientId") Long clientId, @NonNull @PathVariable("fidelityProgramId") Long fidelityProgramId){
         this.clientService.registerToFidelityProgram(this.companyService.findById(companyId), this.fidelityProgramService.findById(fidelityProgramId), this.clientService.findById(clientId));
    }

    @GetMapping(path = "/{clientId}/getDigitalWallet/{digitalWalletId}/getDigitalCard/{digitalCardId}")
    public DigitalCard viewDigitalCard(@NonNull @PathVariable("clientId") Long clientId, @NonNull @PathVariable("digitalWalletId") Long digitalWalletId, @NonNull @PathVariable("digitalCardId") Long digitalCardId){
        return this.clientService.viewDigitalCard(clientId,digitalWalletId,digitalCardId);
    }

    @DeleteMapping(path = "/delete/{clientId}")
    public void deleteById(@NonNull @PathVariable("clientId") Long clientId){
        this.clientService.deleteById(clientId);
    }

    @DeleteMapping(path = "/deleteAll")
    public void deleteAll(){
        this.clientService.deleteAll();
    }

}
