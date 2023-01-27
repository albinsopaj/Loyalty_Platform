package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private Campaign campaign;

    @PostMapping(path = "/add/{campaign}/")
    public Campaign addCampaign(@NonNull @RequestBody @PathVariable("campaign") Campaign campaign) {
        return this.campaignService.save(campaign);
    }

    @GetMapping(path = "/campaign/{campaignId}")
    public Campaign getCampaign(@NonNull @PathVariable("campaignId") Long id) {
        return this.campaignService.findById(id);
    }

    @GetMapping(path = "/campaigns")
    public List<Campaign> getAllCampaigns() {
        return this.campaignService.getAll();
    }

    @PutMapping(path = "/update/{campaign}")
    public Campaign updateCampaign(@NonNull @RequestBody @PathVariable("campaign") Campaign campaign) {
        return this.campaignService.update(campaign);
    }

    @DeleteMapping(path = "/delete/{campaignId}")
    public void deleteCampaign(@NonNull @PathVariable("campaignId") Long id) {
        this.campaignService.deleteById(id);
    }

    @DeleteMapping(path = "/delete/{campaign}")
    public void deleteCampaign(@NonNull @PathVariable("campaign") Campaign campaign) {
        this.campaignService.delete(campaign);
    }

}
