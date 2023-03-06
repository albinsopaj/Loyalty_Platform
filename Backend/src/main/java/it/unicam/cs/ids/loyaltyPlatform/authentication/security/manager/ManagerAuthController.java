package it.unicam.cs.ids.loyaltyPlatform.authentication.security.manager;

import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.*;
import it.unicam.cs.ids.loyaltyPlatform.authentication.payload.SignupRequest.ManagerSignupRequest;
import it.unicam.cs.ids.loyaltyPlatform.authentication.security.JwUtils;
import it.unicam.cs.ids.loyaltyPlatform.model.company.CompanyRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserRepository;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.Manager;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.ManagerRepository;
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
@RequestMapping("/api/auth/manager")
public class ManagerAuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    ManagerRepository managerRepository;
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
        String token = jwtUtils.generateManagerJwtToken(authentication);

        ManagerDetailsImpl managerDetails = (ManagerDetailsImpl) authentication.getPrincipal();
        List<String> roles = managerDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        String role = roles.get(0);

        return ResponseEntity.ok(new JwtResponse(token,
                managerDetails.getId(),
                managerDetails.getUsername(),
                managerDetails.getEmail(),
                role,
                managerDetails.getFirstName(),
                managerDetails.getLastName(),
                managerDetails.getPhoneNumber(),
                managerDetails.getBiologicalGender(),
                managerDetails.getDomicile()));
    }

    @PostMapping("/signup")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    public ResponseEntity<?> registerUser(@Valid @RequestBody ManagerSignupRequest managerSignUpRequest) {
        if (authenticatedUserRepository.existsByUsername(managerSignUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (authenticatedUserRepository.existsByEmail(managerSignUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Manager manager = new Manager();
        manager.setFirstName(managerSignUpRequest.getFirstName());
        manager.setLastName(managerSignUpRequest.getLastName());
        manager.setEmail(managerSignUpRequest.getEmail());
        manager.setPhoneNumber(managerSignUpRequest.getPhoneNumber());
        manager.setBiologicalGender(managerSignUpRequest.getBiologicalGender());
        manager.setDomicile(managerSignUpRequest.getDomicile());
        manager.setUsername(managerSignUpRequest.getUsername());
        manager.setPassword(encoder.encode(managerSignUpRequest.getPassword()));
        manager.setCompany(companyRepository.getReferenceById(managerSignUpRequest.getCompanyId()));
        managerRepository.save(manager);

        return ResponseEntity.ok(new MessageResponse("Manager registered successfully!"));
    }
}
