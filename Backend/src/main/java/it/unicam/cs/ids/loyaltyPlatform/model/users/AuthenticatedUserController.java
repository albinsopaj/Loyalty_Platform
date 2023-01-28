package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loayltyPlatform/authenticateduser")
public abstract class AuthenticatedUserController {

    @Autowired
    private AuthenticatedUserService authenticatedUserService;

    @GetMapping("/{id}")
    public AuthenticatedUser getAuthenticatedUser(@NonNull @PathVariable Long id) {
        return this.authenticatedUserService.findById(id);
    }

    @GetMapping("/getall")
    public List<AuthenticatedUser> getAllAuthenticatedUsers() {
        return this.authenticatedUserService.getAll();
    }

    @PutMapping("/update/{AuthenticatedUser}")
    public AuthenticatedUser updateAuthenticatedUser(@NonNull @RequestBody @PathVariable("AuthenticatedUser") AuthenticatedUser authenticatedUser) {
        return this.authenticatedUserService.update(authenticatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAuthenticatedUser(@NonNull @PathVariable("id") Long id) {
        this.authenticatedUserService.deleteById(id);
    }

    @DeleteMapping("delete/{authenticatedUser}")
    public void deleteAuthenticatedUser(@NonNull @PathVariable AuthenticatedUser authenticatedUser) {
        this.authenticatedUserService.delete(authenticatedUser);
    }

    @DeleteMapping("/{email}")
    public void deleteUserByEmail(@NonNull String email) {
        this.authenticatedUserService.deleteByEmail(email);
    }

}
