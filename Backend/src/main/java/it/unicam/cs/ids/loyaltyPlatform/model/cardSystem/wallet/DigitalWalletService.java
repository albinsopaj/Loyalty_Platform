package it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import lombok.NonNull;

import java.util.List;

public interface DigitalWalletService {

    DigitalWallet save(@NonNull DigitalWallet digitalCard);

    DigitalWallet saveById(@NonNull Long id);

    DigitalWallet findById(@NonNull Long id);

    List<DigitalWallet> getAll();

    DigitalWallet update(DigitalWallet digitalCard);

    DigitalWallet updateById(@NonNull Long id);

    void delete(@NonNull DigitalWallet digitalCard);

    void deleteById(@NonNull Long id);

}
