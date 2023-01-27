package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/manager")
public class ManagerController  {

    @Autowired
    private ManagerServiceImpl managerService;

    @PostMapping("/add")
    public Manager add(@NonNull @RequestBody Manager manager) {
        return this.managerService.save(manager);
    }

    @GetMapping("/get/{id}")
    public Manager get(@NonNull Long id) {
        return this.managerService.findById(id);
    }

    @GetMapping("/getAll")
    public List<Manager> getAll() {
        return this.managerService.getAll();
    }

    @PutMapping("/update/{manager}")
    public Manager update(@NonNull @RequestBody @PathVariable("manager") Manager manager) {
        return this.managerService.update(manager);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.managerService.delete(id);
    }

    //questo metodo potrebbe non funzionare in quanto è improbabile che un oggetto venga passato direttamente nell'URL
    @DeleteMapping("delete/{manager}")
    public void delete(@NonNull @RequestBody @PathVariable Manager manager) {
        this.managerService.delete(manager);
    }

    @DeleteMapping("/delete/{email}")
    public void delete(@NonNull @PathVariable String email) {
        this.managerService.delete(email);
    }

}
