package it.unicam.cs.ids.loyaltyPlatform.authentication.security.cashier;

import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.*;
import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.SignupRequest.CashierSignupRequest;
import it.unicam.cs.ids.loyaltyPlatform.authentication.security.JwUtils;
import it.unicam.cs.ids.loyaltyPlatform.model.company.CompanyRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier.Cashier;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier.CashierRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/auth/cashier")
public class CashierAuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    CashierRepository cashierRepository;
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
        String jwt = jwtUtils.generateCashierJwtToken(authentication);

        CashierDetailsImpl cashierDetails = (CashierDetailsImpl) authentication.getPrincipal();
        List<String> roles = cashierDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        String role = roles.get(0);

        return ResponseEntity.ok(new JwtResponse(jwt,
                cashierDetails.getId(),
                cashierDetails.getUsername(),
                cashierDetails.getEmail(),
                role));
    }

    @PostMapping("/signup")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    public ResponseEntity<?> registerUser(@Valid @RequestBody CashierSignupRequest cashierSignUpRequest) {
        if (authenticatedUserRepository.existsByUsername(cashierSignUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (authenticatedUserRepository.existsByEmail(cashierSignUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Cashier cashier = new Cashier();
        cashier.setFirstName(cashierSignUpRequest.getFirstName());
        cashier.setLastName(cashierSignUpRequest.getLastName());
        cashier.setEmail(cashierSignUpRequest.getEmail());
        cashier.setPhoneNumber(cashierSignUpRequest.getPhoneNumber());
        cashier.setBiologicalGender(cashierSignUpRequest.getBiologicalGender());
        cashier.setDomicile(cashierSignUpRequest.getDomicile());
        cashier.setUsername(cashierSignUpRequest.getUsername());
        cashier.setPassword(encoder.encode(cashierSignUpRequest.getPassword()));
        cashier.setCompany(companyRepository.getReferenceById(cashierSignUpRequest.getCompanyId()));
        cashierRepository.save(cashier);

        return ResponseEntity.ok(new MessageResponse("Cashier registered successfully!"));
    }
}