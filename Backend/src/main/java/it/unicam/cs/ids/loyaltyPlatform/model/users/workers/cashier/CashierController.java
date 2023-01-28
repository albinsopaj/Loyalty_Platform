package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CashierController extends AuthenticatedUserController {

    @Autowired
    private CashierServiceImpl cashierService;

    /**
     *  Method to add a cashier
     *
     * @param cashier the cashier to add
     * @return
     */

    @PostMapping("/cashier")
    public Cashier addCashier(@NonNull @RequestBody Cashier cashier) {
        return this.cashierService.save(cashier);
    }

}
