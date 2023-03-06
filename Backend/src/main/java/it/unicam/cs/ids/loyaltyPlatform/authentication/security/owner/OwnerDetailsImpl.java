package it.unicam.cs.ids.loyaltyPlatform.authentication.security.owner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner.Owner;
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
public class OwnerDetailsImpl implements UserDetails {
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
    private List<Company> companies;
    private Collection<? extends GrantedAuthority> authorities;

    public OwnerDetailsImpl(Long id, String firstName, String lastName, String email, String phoneNumber, String biologicalGender, String domicile, String username, String password, List<Company> companies,
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
        this.companies = companies;
        this.authorities = authorities;
    }

    public static OwnerDetailsImpl build(Owner owner) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_OWNER"));
        return new OwnerDetailsImpl(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName(),
                owner.getEmail(),
                owner.getPhoneNumber(),
                owner.getBiologicalGender(),
                owner.getDomicile(),
                owner.getUsername(),
                owner.getPassword(),
                owner.getCompanies(),
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
        OwnerDetailsImpl owner = (OwnerDetailsImpl) o;
        return Objects.equals(id, owner.id);
    }
}
