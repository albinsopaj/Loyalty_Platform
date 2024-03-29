package it.unicam.cs.ids.loyaltyPlatform.authentication.security.client;

import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.JwtResponse;
import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.LoginRequest;
import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.MessageResponse;
import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.SignupRequest.ClientSignupRequest;
import it.unicam.cs.ids.loyaltyPlatform.authentication.security.JwUtils;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWallet;
import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.wallet.DigitalWalletRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"}, maxAge = 3600)
@RestController
@RequestMapping("/api/auth/client")
public class ClientAuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AuthenticatedUserRepository authenticatedUserRepository;
    @Autowired
    DigitalWalletRepository digitalWalletRepository;
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateClientJwtToken(authentication);

        ClientDetailsImpl clientDetails = (ClientDetailsImpl) authentication.getPrincipal();
        List<String> roles = clientDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        String role = roles.get(0);

        return ResponseEntity.ok(new JwtResponse(token,
                clientDetails.getId(),
                clientDetails.getUsername(),
                clientDetails.getEmail(),
                role,
                clientDetails.getFirstName(),
                clientDetails.getLastName(),
                clientDetails.getPhoneNumber(),
                clientDetails.getBiologicalGender(),
                clientDetails.getDomicile()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody ClientSignupRequest clientSignUpRequest) {
        if (authenticatedUserRepository.existsByUsername(clientSignUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (authenticatedUserRepository.existsByEmail(clientSignUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Client client = new Client();
        client.setFirstName(clientSignUpRequest.getFirstName());
        client.setLastName(clientSignUpRequest.getLastName());
        client.setEmail(clientSignUpRequest.getEmail());
        client.setPhoneNumber(clientSignUpRequest.getPhoneNumber());
        client.setBiologicalGender(clientSignUpRequest.getBiologicalGender());
        client.setDomicile(clientSignUpRequest.getDomicile());
        client.setUsername(clientSignUpRequest.getUsername());
        client.setPassword(encoder.encode(clientSignUpRequest.getPassword()));
        DigitalWallet digitalWallet = new DigitalWallet();
        digitalWallet.setClient(client);
        client.setDigitalWallet(digitalWallet);
        digitalWalletRepository.save(digitalWallet);
        clientRepository.save(client);

        return ResponseEntity.ok(new MessageResponse("Client registered successfully!"));
    }
}
