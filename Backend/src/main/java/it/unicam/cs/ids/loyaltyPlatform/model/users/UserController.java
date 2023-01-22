package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticatedUser authenticatedUser;

    @PostMapping("/add/{user}")
    public void addUser(@NonNull @RequestBody @Param("user") @PathVariable AuthenticatedUser user) {
        //TODO implement authentication credentials and their relative setRole, updateRoles
        userService.addUser(user);
    }

    public Optional<AuthenticatedUser> getUser(@NonNull Long id) {
        return this.userService.getUser(id);
    }

    @GetMapping("")
    public AuthenticatedUser getUser(String email) {
        return this.userService.getUser(email);
    }

    @GetMapping("/authenticatedUsers")
    public List<AuthenticatedUser> getAllUsers() {
        //TODO da implementare
        return null;
    }

    @PutMapping("")
    @PatchMapping("")
    public AuthenticatedUser updateAuthenticatedUser(@RequestBody @Param("user") AuthenticatedUser user) {
        //TODO implement logic of updating users
        return this.userService.updateAuthenticatedUser(user);
    }

    @DeleteMapping("/authenticatedUsers/{id}")
    public void deleteUserByID(@NonNull Long id) {
        this.userService.deleteUser(id);
    }

    @DeleteMapping("/authenticatedUsers/{email}")
    public void deleteUserByEmail(@NonNull String email) {
        this.userService.deleteUser(email);
    }

}
