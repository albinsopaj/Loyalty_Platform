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

    @PutMapping("/update/{clientId}")
    public Client update(@NonNull @RequestBody @PathVariable("clientId") Long id) {
        return this.clientService.updateById(id);
    }

    @DeleteMapping("/delete/{clientId}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.clientService.deleteById(id);
    }

    @DeleteMapping("delete/{client}")
    public void delete(@NonNull @RequestBody @PathVariable("client") Client client) {
        this.clientService.delete(client);
    }

}
