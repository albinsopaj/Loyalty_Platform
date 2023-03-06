package it.unicam.cs.ids.loyaltyPlatform.authentication.payload;

import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class JwtOwnerResponse extends  JwtResponse {
    private List<Company> companies;

    public JwtOwnerResponse(String token, Long id, String username, String email, String role, String name, String lastName, String phoneNumber, String biologicalGender, String domicile, List<Company> companies){
        super(token,id,username,email,role,name,lastName,phoneNumber,biologicalGender,domicile);
        this.companies = companies;
    }
}
