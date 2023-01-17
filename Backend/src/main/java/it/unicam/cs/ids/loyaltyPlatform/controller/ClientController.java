package it.unicam.cs.ids.loyaltyPlatform.controller;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import it.unicam.cs.ids.loyaltyPlatform.service.ClientService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping("")
    public void addClient(@NonNull @RequestBody @Param("clientName") Client clientName) {
        this.service.addClient(clientName);
    }


}
