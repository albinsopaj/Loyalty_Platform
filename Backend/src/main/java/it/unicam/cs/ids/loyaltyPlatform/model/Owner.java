package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor

public class Owner implements AuthenticatedUser {
    private @NonNull String name;
    private @NonNull String surname;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull char gender;
    private @NonNull String username;
    private @NonNull String password;

    public void createCampaign(PointsFidelityProgram fidelityProgram) {

    }

    public void createNewFidelityProgram() {

    }

    public void createNewRole() {

    }

}
