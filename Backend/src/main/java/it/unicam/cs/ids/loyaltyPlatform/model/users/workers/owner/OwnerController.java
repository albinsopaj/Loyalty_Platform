package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.model.company.Company;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.FidelityLevel;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.level.LevelFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgram;
import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsReward;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier.Cashier;
import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager.Manager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "loyaltyPlatform/owner")
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerService;

    @PostMapping(path = "/add")
    public Owner addOwner(@NonNull @RequestBody Owner owner) {
        return this.ownerService.save(owner);
    }

    @GetMapping(path = "/get/{id}")
    public Owner getOwner(@NonNull @PathVariable("id") Long id) {
        return this.ownerService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Owner> getAll() {
        return this.ownerService.getAll();
    }

    @PutMapping(path = "/update/{id}")
    public Owner update(@NonNull @RequestBody @PathVariable("id") Long id) {
        return this.ownerService.update(this.ownerService.findById(id));
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@NonNull @PathVariable("id") Long id) {
        this.ownerService.deleteById(id);
    }

    @DeleteMapping(path = "delete/")
    public void delete(@NonNull @RequestBody Owner owner) {
        this.ownerService.delete(owner);
    }

    @PostMapping(path = "/addCompany/{ownerId}")
    public Company addCompany(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @RequestBody Company company) {
        return this.ownerService.addCompany(ownerId, company);
    }

    @PostMapping(path = "/addCampaign/{ownerId}/{companyId}")
    public Campaign addCampaign(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody Campaign campaign) {
        return this.ownerService.addCampaign(ownerId, companyId, campaign);
    }

    @PostMapping(path = "/addManager/{ownerId}/{companyId}")
    public Manager addManager(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody Manager manager) {
        return this.ownerService.addManager(ownerId, companyId, manager);
    }

    @PostMapping(path = "/addPointsFidelityProgram/{ownerId}/{companyId}")
    public PointsFidelityProgram addPointsFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody PointsFidelityProgram pointsFidelityProgram) {
        return this.ownerService.addPointsFidelityProgram(ownerId, companyId, pointsFidelityProgram);
    }

    @PostMapping(path = "/addPointsReward/{ownerId}/{companyId}/{pointsFidelityProgramId}")
    public PointsReward addPointsReward(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @PathVariable("pointsFidelityProgramId") Long pointsFidelityProgramId, @NonNull @RequestBody PointsReward pointsReward) {
        return this.ownerService.addPointsReward(ownerId, companyId, pointsFidelityProgramId, pointsReward);
    }

    @PostMapping(path = "/addLevelFidelityProgram/{ownerId}/{companyId}")
    public LevelFidelityProgram addLevelFidelityProgram(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody LevelFidelityProgram levelFidelityProgram) {
        return this.ownerService.addLevelFidelityProgram(ownerId, companyId, levelFidelityProgram);
    }

    @PostMapping(path = "/addFidelityLevel/{ownerId}/{companyId}/{levelFidelityProgramId}")
    public FidelityLevel addFidelityLevel(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @PathVariable("levelFidelityProgramId") Long levelFidelityProgramId, @NonNull @RequestBody FidelityLevel fidelityLevel) {
        return this.ownerService.addFidelityLevel(ownerId, companyId, levelFidelityProgramId, fidelityLevel);
    }

    @PostMapping(path = "/addCashier/{ownerId}/{companyId}")
    public Cashier addCashier(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody Cashier cashier) {
        return this.ownerService.addCashier(ownerId, companyId, cashier);
    }

}
