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

//    @PostMapping(path = "/add")
//    public Manager add(@NonNull @RequestBody Manager manager) {
//        return this.managerService.save(manager);
//    }

    @GetMapping(path = "/get/{id}")
    public Manager get(@NonNull Long id) {
        return this.managerService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Manager> getAll() {
        return this.managerService.getAll();
    }

    @PutMapping(path = "/update/{manager}")
    public Manager update(@NonNull @RequestBody @PathVariable("manager") Manager manager) {
        return this.managerService.update(manager);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.managerService.deleteById(id);
    }

    @DeleteMapping(path = "/removeClientFromFidelityProgram/{managerId}/{clientId}/{fidelityProgramId}")
    public void removeClient(@NonNull @PathVariable("managerId") Long managerId, @NonNull @PathVariable("clientId") Long clientId, @NonNull @PathVariable("fidelityProgramId") Long fidelityProgramId) {
        this.managerService.removeClient(managerId, clientId, fidelityProgramId);
    }

}
