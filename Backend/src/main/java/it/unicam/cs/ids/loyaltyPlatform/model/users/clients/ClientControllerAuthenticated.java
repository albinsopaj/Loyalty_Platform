package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import it.unicam.cs.ids.loyaltyPlatform.model.users.AuthenticatedUserController;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientControllerAuthenticated extends AuthenticatedUserController {

    @Autowired
    private ClientServiceImplAuthenticated clientService;

    @Autowired
    private Client client;

    /**
     * Method to add a client
     *
     * @param client the client to add
     * @return
     */
    @PostMapping("/client")
    public Client addClient(@NonNull @RequestBody Client client) {
        return this.clientService.save(client);
    }

}
