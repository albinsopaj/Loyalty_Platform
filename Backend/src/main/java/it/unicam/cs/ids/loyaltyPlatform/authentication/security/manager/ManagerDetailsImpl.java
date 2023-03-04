package it.unicam.cs.ids.loyaltyPlatform.authentication.security.manager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.Manager;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Getter
public class ManagerDetailsImpl implements UserDetails {
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

    public ManagerDetailsImpl(Long id, String firstName, String lastName, String email, String phoneNumber, String biologicalGender, String domicile, String username, String password, Company company,
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

    public static ManagerDetailsImpl build(Manager manager) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        return new ManagerDetailsImpl(
                manager.getId(),
                manager.getFirstName(),
                manager.getLastName(),
                manager.getEmail(),
                manager.getPhoneNumber(),
                manager.getBiologicalGender(),
                manager.getDomicile(),
                manager.getUsername(),
                manager.getPassword(),
                manager.getCompany(),
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
        ManagerDetailsImpl manager = (ManagerDetailsImpl) o;
        return Objects.equals(id, manager.id);
    }
}
