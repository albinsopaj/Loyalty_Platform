package it.unicam.cs.ids.loyaltyPlatform.authentication.security.owner;

import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.*;
import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.SignupRequest.OwnerSignupRequest;
import it.unicam.cs.ids.loyaltyPlatform.authentication.security.JwUtils;
import it.unicam.cs.ids.loyaltyPlatform.model.company.CompanyRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner.Owner;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner.OwnerRepository;
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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/owner")
public class OwnerAuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    OwnerRepository ownerRepository;
    @Autowired
    AuthenticatedUserRepository authenticatedUserRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateOwnerJwtToken(authentication);

        OwnerDetailsImpl ownerDetails = (OwnerDetailsImpl) authentication.getPrincipal();
        List<String> roles = ownerDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        String role = roles.get(0);
        return ResponseEntity.ok(new JwtResponse(token,
                ownerDetails.getId(),
                ownerDetails.getUsername(),
                ownerDetails.getEmail(),
                role));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody OwnerSignupRequest ownerSignUpRequest) {
        if (authenticatedUserRepository.existsByUsername(ownerSignUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (authenticatedUserRepository.existsByEmail(ownerSignUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Owner owner = new Owner();
        owner.setFirstName(ownerSignUpRequest.getFirstName());
        owner.setLastName(ownerSignUpRequest.getLastName());
        owner.setEmail(ownerSignUpRequest.getEmail());
        owner.setPhoneNumber(ownerSignUpRequest.getPhoneNumber());
        owner.setBiologicalGender(ownerSignUpRequest.getBiologicalGender());
        owner.setDomicile(ownerSignUpRequest.getDomicile());
        owner.setUsername(ownerSignUpRequest.getUsername());
        owner.setPassword(encoder.encode(ownerSignUpRequest.getPassword()));
        ownerRepository.save(owner);

        return ResponseEntity.ok(new MessageResponse("Owner registered successfully!"));
    }
}
