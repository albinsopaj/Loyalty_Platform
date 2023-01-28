package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashierController {

    @Autowired
    private CashierServiceImpl cashierService;

    @Autowired
    private Cashier cashier;

    @PostMapping("/cashier")
    public Cashier addCashier(@NonNull @RequestBody Cashier cashier) {
        return this.cashierService.save(cashier);
    }
}
