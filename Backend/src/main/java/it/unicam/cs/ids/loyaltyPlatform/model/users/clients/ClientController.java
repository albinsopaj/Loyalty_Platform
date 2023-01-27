package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.users.UserController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController extends UserController {

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private Client client;

    @PostMapping("/client")
    public Client addClient(@NonNull @RequestBody Client client) {
        return this.clientService.save(client);
    }

}
