package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/owners")
public class OwnerController  {

    @Autowired
    private OwnerServiceImpl ownerService;

    @Autowired
    private Owner owner;

    @PostMapping("/owner")
    public Owner add(@NonNull @RequestBody Owner owner) {
        return this.ownerService.save(owner);
    }

    @GetMapping("/{id}")
    public Owner get(@NonNull Long id) {
        return this.ownerService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Owner> getAll() {
        return this.ownerService.getAll();
    }

    @PutMapping("/update/{owner}")
    public Owner update(@NonNull @RequestBody @PathVariable("owner") Owner owner) {
        return this.ownerService.update(owner);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.ownerService.delete(id);
    }

    @DeleteMapping("delete/{owner}")
    public void delete(@NonNull @RequestBody @PathVariable Owner owner) {
        this.ownerService.delete(owner);
    }

    @DeleteMapping("/{email}")
    public void delete(@NonNull @PathVariable String email) {
        this.ownerService.delete(email);
    }
}
