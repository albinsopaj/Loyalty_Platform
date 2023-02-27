package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.DigitalCardServiceImpl;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsReward;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/cashier")
@CrossOrigin("http://localhost:3000/")
public class CashierController {

    @Autowired
    private CashierServiceImpl cashierService;
    @Autowired
    private DigitalCardServiceImpl digitalCardService;

    @PostMapping(path = "/add")
    public Cashier add(@NonNull @RequestBody @Param("cashier") Cashier cashier) {
        return this.cashierService.save(cashier);
    }

    @GetMapping(path = "/get/{id}")
    public Cashier get(@NonNull Long id) {
        return this.cashierService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Cashier> getAll() {
        return this.cashierService.getAll();
    }

    @PutMapping(path = "/update/{cashierId}")
    public Cashier update(@RequestBody @PathVariable("cashierId") Long id) {
        return this.cashierService.update(get(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteById(@NonNull @PathVariable("id") Long id) {
        this.cashierService.deleteById(id);
    }

    @DeleteMapping(path = "/delete/{cashier}")
    public void delete(@NonNull @PathVariable Cashier cashier) {
        this.cashierService.delete(cashier);
    }

    @GetMapping(path = "/getClient/{clientId}")
    public Client viewClientProfile(@NonNull @PathVariable("clientId") Long clientId) {
        return cashierService.viewClientProfile(clientId);
    }

    @PostMapping(path = "/registerClient")
    public Client registerClient(@NonNull @RequestBody Client client) {
        return this.cashierService.registerClient(client);
    }

    @PutMapping(path = "/{cashierId}/updatePointsDigitalCardStatus/{digitalCardId}")
    public void updatePointsDigitalCardStatus(@NonNull @PathVariable("cashierId") Long cashierId, @NonNull @PathVariable("digitalCardId") Long digitalCardId, @NonNull @RequestBody Integer value) {
        this.cashierService.updatePointsDigitalCardStatus(cashierId, digitalCardId, value);
    }

    @PutMapping(path = "/{cashierId}/updateLevelDigitalCardStatus/{digitalCardId}")
    public void updateLevelDigitalCardStatus(@NonNull @PathVariable("cashierId") Long cashierId, @NonNull @PathVariable("digitalCardId") Long digitalCardId, @NonNull @RequestBody Integer value){
        this.cashierService.updateLevelDigitalCardStatus(cashierId, digitalCardId, value);
    }
    @PutMapping(path = "/redeemReward/{cashierId}/{pointsDigitalCardId}")
    public boolean redeemReward(@NonNull @PathVariable("cashierId") Long cashierId, @NonNull @PathVariable("pointsDigitalCardId") Long pointsDigitalCardId, @NonNull @RequestBody PointsReward pointsReward){
        return this.cashierService.redeemReward(cashierId, pointsDigitalCardId, pointsReward);
    }


}
