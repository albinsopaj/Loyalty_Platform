package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.owner.Owner;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;
    private Owner owner;

    @PostMapping(path = "/add")
    public Campaign addCampaign(@NonNull @RequestBody Campaign campaign) {
        this.owner.createCampaign(campaign.getName(), campaign.getStart(), campaign.getEnd(), campaign.getDescription());
        return this.campaignService.save(campaign);
    }

    @GetMapping(path = "/{campaignId}")
    public Campaign getCampaign(@NonNull @PathVariable("campaignId") Long id) {
        return this.campaignService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Campaign> getAllCampaigns() {
        return this.campaignService.getAll();
    }

    @PutMapping(path = "/update/{campaignId}")
    public Campaign updateCampaign(@NonNull @PathVariable("campaignId") Long id, @RequestBody Campaign campaign) {
        return this.campaignService.update(campaign);
    }

    @DeleteMapping(path = "/delete/{campaignId}")
    public void deleteCampaign(@NonNull @PathVariable("campaignId") Long id) {
        this.campaignService.deleteById(id);
    }

    @DeleteMapping(path = "/delete")
    public void deleteCampaign(@NonNull @Param("campaign") Campaign campaign) {
        this.campaignService.delete(campaign);
    }

}
