package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cashier implements AuthenticatedUser {

    private @NonNull String name;
    private @NonNull String surname;
    private @NonNull char gender;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull String username;
    private @NonNull String password;

    public void viewClientProfile() {

    }

    public void updatePointsStatusManually() {

    }

    public void scanQrCode() {

    }
}
