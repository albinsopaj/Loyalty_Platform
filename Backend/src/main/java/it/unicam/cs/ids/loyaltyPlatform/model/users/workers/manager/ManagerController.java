package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import it.unicam.cs.ids.loyaltyPlatform.model.users.UserController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController extends UserController {
    @Autowired
    private ManagerServiceImpl managerService;

    @Autowired
    private Manager manager;

    @PostMapping("/manager")
    public Manager addManager(@NonNull @RequestBody Manager manager) {
        return this.managerService.save(manager);
    }
}
