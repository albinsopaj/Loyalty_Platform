package it.unicam.cs.ids.loyaltyPlatform.authentication.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"}, maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/client")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public String userAccess() {
        return "Client Content.";
    }

    @GetMapping("/cashier")
    @PreAuthorize("hasRole('ROLE_CASHIER')")
    public String moderatorAccess() {
        return "Cashier Board.";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public String managerAccess() {
        return "Manager Board.";
    }
    @GetMapping("/owner")
    @PreAuthorize("hasRole('ROLE_OWNER')")
    public String ownerAccess() {
        return "Owner Board.";
    }
}