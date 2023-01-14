package it.unicam.cs.ids.loyaltyPlatform.controller;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserInterface;
import it.unicam.cs.ids.loyaltyPlatform.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public void addAuthenticatedUser(@RequestBody @Param("user") AuthenticatedUserInterface user) {
        //TODO implement authentication credentials and their relative setRole, updateRoles
        userService.addAuthenticatedUser(user);
    }

    public AuthenticatedUserInterface getUserByID(UUID id) {
        return userService.getUserByID(id);
    }

    @GetMapping("")
    public List<AuthenticatedUserInterface> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PutMapping("")
    @PatchMapping("")
    public AuthenticatedUserInterface updateAuthenticatedUser(@RequestBody @Param("user") AuthenticatedUserInterface user) {
        //TODO implement logic of updating users
        //incomplete method body
        var u = this.userService.getUserByID(user.getID());
        return this.userService.updateAuthenticatedUser(user);
    }

    @DeleteMapping("")
    public boolean deleteUserByID(@NonNull UUID id) {
        return this.userService.deleteUser(id);
    }

    @DeleteMapping("")
    public boolean deleteUserByEmail(@NonNull String email) {
        return this.userService.deleteUser(email);
    }

}
