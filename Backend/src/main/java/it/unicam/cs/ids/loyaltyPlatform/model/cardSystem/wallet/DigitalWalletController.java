package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DigitalWalletController {

    @Autowired
    private DigitalWalletService digitalWalletService;

    private DigitalWallet digitalWallet;

    @PostMapping(path = "/add/{digitalWallet}/")
    public DigitalWallet addDigitalWallet(@NonNull @RequestBody @PathVariable("digitalWallet") DigitalWallet digitalWallet) {
        return this.digitalWalletService.save(digitalWallet);
    }

    @GetMapping(path = "/digitalWallet/{digitalWalletId}")
    public DigitalWallet getDigitalWallet(@NonNull @PathVariable("digitalWalletId") Long id) {
        return this.digitalWalletService.findById(id);
    }

    @GetMapping(path = "/digitalWallets")
    public List<DigitalWallet> getAllDigitalWallets() {
        return this.digitalWalletService.getAll();
    }

    @PutMapping(path = "/update/{digitalWallet}")
    public DigitalWallet updateDigitalWallet(@NonNull @RequestBody @PathVariable("digitalWallet") DigitalWallet digitalWallet) {
        return this.digitalWalletService.update(digitalWallet);
    }

    @DeleteMapping(path = "/delete/{digitalWalletId}")
    public void deleteDigitalWallet(@NonNull @PathVariable("digitalWalletId") Long id) {
        this.digitalWalletService.deleteById(id);
    }

    @DeleteMapping(path = "/delete/{digitalWallet}")
    public void deleteDigitalWallet(@NonNull @PathVariable("digitalWallet") DigitalWallet digitalWallet) {
        this.digitalWalletService.delete(digitalWallet);
    }

}