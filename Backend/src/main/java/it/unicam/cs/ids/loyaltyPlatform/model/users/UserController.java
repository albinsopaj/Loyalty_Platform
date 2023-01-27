package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public abstract class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @GetMapping("AuthenticatedUser/{id}")
    public AuthenticatedUser getAuthenticatedUser(@NonNull @PathVariable Long id) {
        return this.userService.findById(id);
    }

    @GetMapping("/AuthenticatedUsers")
    public List<AuthenticatedUser> getAllAuthenticatedUsers() {
        return this.userService.getAll();
    }

    @PutMapping("/update/{AuthenticatedUser}")
    public AuthenticatedUser updateAuthenticatedUser(@NonNull @RequestBody @PathVariable("AuthenticatedUser") AuthenticatedUser authenticatedUser) {
        return this.userService.update(authenticatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuthenticatedUser(@NonNull @PathVariable("id") Long id) {
        this.userService.deleteById(id);
    }

    @DeleteMapping("delete/{AuthenticatedUser}")
    public void deleteAuthenticatedUser(@NonNull @PathVariable AuthenticatedUser authenticatedUser) {
        this.userService.delete(authenticatedUser);
    }

    @DeleteMapping("/authenticatedUsers/{email}")
    public void deleteUserByEmail(@NonNull String email) {
        this.userService.deleteByEmail(email);
    }
}
