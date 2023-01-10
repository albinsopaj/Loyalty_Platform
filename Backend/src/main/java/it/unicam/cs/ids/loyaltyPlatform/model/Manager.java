package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Manager implements AuthenticatedUser {

    private @NonNull String name;
    private @NonNull String surname;
    private @NonNull char gender;
    private @NonNull String email;
    private @NonNull int id;
    private @NonNull String phoneNumber;
    private @NonNull String username;
    private @NonNull String password;

    public void updatePointsStatusManually(Client client, int points) {
        client.viewDigitalCard().setPoints(points);
    }

    public void sendCommunications() {

    }

}
