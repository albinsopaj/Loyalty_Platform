package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/owner")
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerService;

    @PostMapping("/add")
    public Owner add(@NonNull @RequestBody Owner owner) {
        return this.ownerService.save(owner);
    }

    @GetMapping("/get/{id}")
    public Owner get(@NonNull @PathVariable("id") Long id) {
        return this.ownerService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Owner> getAll() {
        return this.ownerService.getAll();
    }

    @PutMapping("/update/{id}")
    public Owner update(@NonNull @RequestBody @PathVariable("id") Long id) {
        return this.ownerService.update(this.ownerService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.ownerService.deleteById(id);
    }

    //questo metodo potrebbe non funzionare in quanto è improbabile che un oggetto diretto venga passato direttamente nell'URL
    @DeleteMapping("/delete/{owner}")
    public void delete(@NonNull @RequestBody @PathVariable Owner owner) {
        this.ownerService.delete(owner);
    }

}
