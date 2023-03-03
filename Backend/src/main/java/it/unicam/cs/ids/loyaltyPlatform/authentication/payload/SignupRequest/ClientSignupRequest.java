package it.unicam.cs.ids.loyaltyPlatform.authentication.payload.SignupRequest;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ClientSignupRequest {

    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull String biologicalGender;
    private @NonNull String domicile;
    private @NonNull String username;
    private @NonNull String password;
    private DigitalWallet digitalWallet;
    private Set<Long> fidelityProgramIds;
}
