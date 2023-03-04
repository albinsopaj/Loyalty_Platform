package it.unicam.cs.ids.loyaltyPlatform.authentication.payload.SignupRequest;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class OwnerSignupRequest {

    private @NonNull String firstName;
    private @NonNull String lastName;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull String biologicalGender;
    private @NonNull String domicile;
    private @NonNull String username;
    private @NonNull String password;
}
