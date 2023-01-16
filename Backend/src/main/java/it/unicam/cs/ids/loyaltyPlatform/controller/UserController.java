package it.unicam.cs.ids.loyaltyPlatform.controller;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUser;
import it.unicam.cs.ids.loyaltyPlatform.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public void addUser(@NonNull @RequestBody @Param("user") AuthenticatedUser user) {
        //TODO implement authentication credentials and their relative setRole, updateRoles
        userService.addUser(user);
    }

    public Optional<AuthenticatedUser> getUser(@NonNull UUID id) {
        return this.userService.getUser(id);
    }

    public AuthenticatedUser getUser(String email) {
        return this.userService.getUser(email);
    }

    @GetMapping("")
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

    @DeleteMapping("")
    public void deleteUserByID(@NonNull UUID id) {
        this.userService.deleteUser(id);
    }

    @DeleteMapping("")
    public void deleteUserByEmail(@NonNull String email) {
        this.userService.deleteUser(email);
    }

}
