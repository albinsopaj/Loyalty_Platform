package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/owner")
public class OwnerController {

    @Autowired
    private OwnerServiceImpl ownerService;

    @PostMapping(path = "/add")
    public Owner add(@NonNull @RequestBody Owner owner) {
        return this.ownerService.save(owner);
    }

    @GetMapping(path = "/get/{id}")
    public Owner get(@NonNull @PathVariable("id") Long id) {
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

    @PostMapping(path = "/{ownerId}/getCompanies/{companyId}/addCampaign")
    public Campaign addCampaign(@NonNull @PathVariable("ownerId") Long ownerId, @NonNull @PathVariable("companyId") Long companyId, @NonNull @RequestBody @PathVariable Campaign campaign){
        return this.ownerService.addCampaign(ownerId, companyId, campaign);
    }
}
