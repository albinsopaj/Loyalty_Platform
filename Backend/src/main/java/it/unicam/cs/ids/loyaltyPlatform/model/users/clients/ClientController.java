package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Controller
@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping("/client/{clientName}")
    public void addClient(@NonNull @RequestBody @Param("clientName") @PathVariable Client clientName) {
        this.service.addClient(clientName);
    }

    @PostMapping
    public void updatePoints(@NonNull UUID id) {

    }

}
