package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CashierController {
    @Autowired
    private CashierServiceImpl cashierService;

    @Autowired
    private Cashier cashier;

    @PostMapping("/cashier")
    public Cashier add(@NonNull @RequestBody Cashier cashier) {
        return this.cashierService.save(cashier);
    }

    @GetMapping("/{id}")
    public Cashier get(@NonNull Long id) {
        return this.cashierService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Cashier> getAll() {
        return this.cashierService.getAll();
    }

    @PutMapping("/update/{cashier}")
    public Cashier update(@NonNull @RequestBody @PathVariable("cashier") Cashier cashier) {
        return this.cashierService.update(cashier);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.cashierService.delete(id);
    }

    @DeleteMapping("delete/{cashier}")
    public void delete(@NonNull @RequestBody @PathVariable Cashier cashier) {
        this.cashierService.delete(cashier);
    }

    @DeleteMapping("/{email}")
    public void delete(@NonNull @PathVariable String email) {
        this.cashierService.delete(email);
    }
}
