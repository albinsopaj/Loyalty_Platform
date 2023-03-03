package it.unicam.cs.ids.loyaltyPlatform.authentication.security.cashier;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier.Cashier;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serial;
import java.util.*;

@Getter
public class CashierDetailsImpl implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String biologicalGender;
    private String domicile;
    private String username;
    @JsonIgnore
    private String password;
    private Company company;
    private Collection<? extends GrantedAuthority> authorities;

    public CashierDetailsImpl(Long id, String firstName, String lastName, String email, String phoneNumber, String biologicalGender, String domicile, String username, String password, Company company,
                             Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.biologicalGender = biologicalGender;
        this.domicile = domicile;
        this.username = username;
        this.password = password;
        this.company = company;
        this.authorities = authorities;
    }

    public static CashierDetailsImpl build(Cashier cashier) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_CASHIER"));
        return new it.unicam.cs.ids.loyaltyPlatform.authentication.security.cashier.CashierDetailsImpl(
                cashier.getId(),
                cashier.getFirstName(),
                cashier.getLastName(),
                cashier.getEmail(),
                cashier.getPhoneNumber(),
                cashier.getBiologicalGender(),
                cashier.getDomicile(),
                cashier.getUsername(),
                cashier.getPassword(),
                cashier.getCompany(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CashierDetailsImpl cashier = (CashierDetailsImpl) o;
        return Objects.equals(id, cashier.id);
    }
}
