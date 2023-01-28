package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerControllerAuthenticated extends AuthenticatedUserController {

    @Autowired
    private OwnerServiceImplAuthenticated ownerService;

    @Autowired
    private Owner owner;

    /**
     *  Method to add a owner
     *
     * @param owner the owner to add
     * @return
     */
    @PostMapping("/owner")
    public Owner addOwner(@NonNull @RequestBody Owner owner) {
        return this.ownerService.save(owner);
    }
}
