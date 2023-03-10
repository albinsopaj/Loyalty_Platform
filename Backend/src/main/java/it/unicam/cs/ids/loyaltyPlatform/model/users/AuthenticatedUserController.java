package it.unicam.cs.ids.loyaltyPlatform.model.users;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "loyaltyPlatform/user")
public class AuthenticatedUserController {
    @Autowired
    private AuthenticatedUserServiceImpl authenticatedUserService;
    @GetMapping(path = "/get/{id}")
    public AuthenticatedUser getUser(@NonNull @PathVariable("id") Long id) {
        return this.authenticatedUserService.findById(id);
    }
}
