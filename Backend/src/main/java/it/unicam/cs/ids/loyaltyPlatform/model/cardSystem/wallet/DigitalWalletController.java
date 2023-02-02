package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/digitalWallet")
public class DigitalWalletController {

    @Autowired
    private DigitalWalletServiceImpl digitalWalletService;

    @GetMapping(path = "/digitalWallet/{digitalWalletId}")
    public DigitalWallet getDigitalWallet(@NonNull @PathVariable("digitalWalletId") Long id) {
        return this.digitalWalletService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<DigitalWallet> getAllDigitalWallets() {
        return this.digitalWalletService.getAll();
    }

    @DeleteMapping(path = "/deleteAll")
    public void deleteAll() {
        this.digitalWalletService.deleteAll();
    }

}