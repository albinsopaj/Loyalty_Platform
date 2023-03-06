package it.unicam.cs.ids.loyaltyPlatform.authentication.payload;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private String email;
    private String role;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String biologicalGender;
    private String domicile;

    public JwtResponse(String token, Long id, String username, String email, String role, String firstName, String lastName, String phoneNumber, String biologicalGender, String domicile) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.biologicalGender = biologicalGender;
        this.domicile = domicile;
    }

}
