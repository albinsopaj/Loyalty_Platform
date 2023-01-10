package it.unicam.cs.ids.loyaltyPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import java.util.Date;

@Getter
@AllArgsConstructor

public class Client {

    private @NonNull String name;
    private @NonNull String surname;
    private @NonNull Date birthday;
    private @NonNull String email;
    private @NonNull String phoneNumber;
    private @NonNull String domicile;
    private @NonNull char gender;
    private String username;
    private @NonNull String password;

    public DigitalCard viewDigitalCard() {
        return null;
    }

    public void downloadDigitalCard() {

    }
}