package it.unicam.cs.ids.loyaltyPlatform.model.users.clients;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/client")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping("/add")
    public Client add(@NonNull @RequestBody Client client) {
        return this.clientService.save(client);
    }

    @GetMapping("/get/{clientId}")
    public Client get(@NonNull @PathVariable("clientId") Long id) {
        return this.clientService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Client> getAll() {
        return this.clientService.getAll();
    }

    @PutMapping("/update/{client}")
    public Client update(@NonNull @RequestBody @PathVariable("client") Client client) {
        return this.clientService.update(client);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.clientService.delete(id);
    }

    //questo metodo potrebbe non funzionare in quanto è improbabile che un oggetto venga passato direttamente nell'URL
    @DeleteMapping("delete/{client}")
    public void delete(@NonNull @RequestBody @PathVariable Client client) {
        this.clientService.delete(client);
    }

    @DeleteMapping("/delete/{email}")
    public void delete(@NonNull @PathVariable String email) {
        this.clientService.delete(email);
    }

}
