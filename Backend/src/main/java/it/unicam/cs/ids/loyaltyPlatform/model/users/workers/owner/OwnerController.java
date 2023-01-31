package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.FidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.Manager;
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
    @PostMapping("/{ownerId}/getCompanies/{companyId}/addCampaign")
    public Campaign addCampaign(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody Campaign campaign){
        return this.ownerService.addCampaign(ownerId, companyId, campaign);
    }
    @PostMapping("/{ownerId}/getCompanies/{companyId}/addManager")
    public Manager addManager(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody Manager manager){
        return this.ownerService.addManager(ownerId,companyId,manager);
    }
    @PostMapping("/{ownerId}/getCompanies/{companyId}/addPointsFidelityProgram")
    public PointsFidelityProgram addPointsFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody PointsFidelityProgram pointsFidelityProgram){
        return this.ownerService.addPointsFidelityProgram(ownerId, companyId, pointsFidelityProgram);
    }

    @PostMapping("/{ownerId}/getCompanies/{companyId}/addLevelFidelityProgram")
    public LevelFidelityProgram addLevelFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody LevelFidelityProgram levelFidelityProgram){
        return this.ownerService.addLevelFidelityProgram(ownerId, companyId, levelFidelityProgram);
    }

    @PostMapping("/{ownerId}/getCompanies/{companyId}/addFidelityProgram")
    public FidelityProgram addFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody FidelityProgram fidelityProgram){
        return this.ownerService.addFidelityProgram(ownerId, companyId, fidelityProgram);
    }
    @PostMapping("/{ownerId}/addCompany")
    public Company addCompany(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @RequestBody Company company){
        return this.ownerService.addCompany(ownerId,company);
    }
}
