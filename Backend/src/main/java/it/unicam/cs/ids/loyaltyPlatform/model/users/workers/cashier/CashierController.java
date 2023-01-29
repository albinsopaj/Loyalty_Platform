package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.cards.points.PointsDigitalCardServiceImpl;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/cashier")
public class CashierController {

    @Autowired
    private CashierServiceImpl cashierService;
    @Autowired
    private PointsDigitalCardServiceImpl pointsDigitalCardService;

    @PostMapping("/add")
    public Cashier add(@NonNull @RequestBody @Param("cashier") Cashier cashier) {
        return this.cashierService.save(cashier);
    }

    @GetMapping("/get/{id}")
    public Cashier get(@NonNull Long id) {
        return this.cashierService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Cashier> getAll() {
        return this.cashierService.getAll();
    }

    @PutMapping("/update/{cashierId}")
    public Cashier update(@RequestBody @PathVariable("cashierId") Long id) {
        return this.cashierService.update(get(id));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.cashierService.deleteById(id);
    }

    //questo metodo potrebbe non funzionare in quanto è improbabile che un oggetto venga passato direttamente nell'URL
    @DeleteMapping("delete/{cashier}")
    public void delete(@NonNull @PathVariable Cashier cashier) {
        this.cashierService.delete(cashier);
    }



    @PutMapping(path = "/update/pointsDigitalCard/{id}/{value}")
    public void updatePointsDigitalCard(@NonNull @PathVariable("id") Long pointsDigitalCardId, @NonNull Integer value) {
        cashierService.updatePointsDigitalCard(pointsDigitalCardService.findById(pointsDigitalCardId), value);
    }
}