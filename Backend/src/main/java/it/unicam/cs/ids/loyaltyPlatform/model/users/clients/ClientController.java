package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCard;
import it.unicam.cs.ids.loyaltyPlatform.model.company.CompanyServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramReview;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgramServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private FidelityProgramServiceImpl fidelityProgramService;
    @Autowired
    private CompanyServiceImpl companyService;


    /***********************************
     ** Owner related CRUD operations **
     **********************************/

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
    public Client registerToFidelityProgram(@NonNull @PathVariable("companyId") Long companyId, @NonNull @PathVariable("clientId") Long clientId, @NonNull @PathVariable("fidelityProgramId") Long fidelityProgramId){
        return this.clientService.registerToFidelityProgram(this.companyService.findById(companyId), this.fidelityProgramService.findById(fidelityProgramId), this.clientService.findById(clientId));
    }

    @PostMapping(path = "/{clientId}/fidelityPrograms/{fidelityProgramId}/writeReview")
    public void writeReview(@NonNull @PathVariable Long clientId, @NonNull @PathVariable Long fidelityProgramId, @NonNull @RequestBody FidelityProgramReview review){
        this.clientService.writeReview(clientId, fidelityProgramId, review );
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
