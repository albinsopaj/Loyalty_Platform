package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.users.UserController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController extends UserController {

    @Autowired
    private OwnerServiceImpl ownerService;

    @Autowired
    private Owner owner;

    @PostMapping("/owner")
    public Owner addOwner(@NonNull @RequestBody Owner owner) {
        return this.ownerService.save(owner);
    }
}
