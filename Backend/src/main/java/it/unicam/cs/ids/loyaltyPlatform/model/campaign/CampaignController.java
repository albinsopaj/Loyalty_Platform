package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "loyaltyPlatform/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private Campaign campaign;

    @PostMapping("/campaign")
    public Campaign addCampaign(@RequestBody Campaign campaign) {
        return this.campaignService.save(campaign);
    }

    @GetMapping("campaign/{id}")
    public Campaign getCampaign(@NonNull @PathVariable("id") UUID id) {
        return this.campaignService.findById(id);
    }

    @GetMapping("/campaigns")
    public List<Campaign> getAllCampaigns() {
        return this.campaignService.getAll();
    }

    @PutMapping("/update/{campaign}")
    public Campaign updateCampaign(@RequestBody @PathVariable("campaign") Campaign campaign) {
        return this.campaignService.update(campaign);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCampaign(@NonNull @PathVariable("id") UUID id) {
        this.campaignService.deleteById(id);
    }

    @DeleteMapping("delete/{campaign}")
    public void deleteCampaign(@NonNull Campaign campaign) {
        this.campaignService.delete(campaign);
    }

}
