package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerControllerAuthenticated extends AuthenticatedUserController {
    @Autowired
    private ManagerServiceImplAuthenticated managerService;

    @Autowired
    private Manager manager;

    /**
     *  Method to add a manager
     *
     * @param manager the manager to add
     * @return
     */
    @PostMapping("/manager")
    public Manager addManager(@NonNull @RequestBody Manager manager) {
        return this.managerService.save(manager);
    }
}
