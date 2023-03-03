package it.unicam.cs.ids.loyaltyPlatform.authentication.security.client;

import java.io.Serial;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
public class ClientDetailsImpl implements UserDetails {
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
    private DigitalWallet digitalWallet;
    private @NonNull Set<Long> fidelityProgramIds = new HashSet<>();
    private Collection<? extends GrantedAuthority> authorities;

    public ClientDetailsImpl(Long id, String firstName, String lastName, String email, String phoneNumber, String biologicalGender, String domicile, String username, String password,
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
        this.authorities = authorities;
    }

    public static ClientDetailsImpl build(Client client) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        return new ClientDetailsImpl(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhoneNumber(),
                client.getBiologicalGender(),
                client.getDomicile(),
                client.getUsername(),
                client.getPassword(),
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
        ClientDetailsImpl client = (ClientDetailsImpl) o;
        return Objects.equals(id, client.id);
    }
}
