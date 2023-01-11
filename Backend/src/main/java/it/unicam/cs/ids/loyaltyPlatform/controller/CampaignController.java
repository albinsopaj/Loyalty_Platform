package it.unicam.cs.ids.loyaltyPlatform.controller;

import it.unicam.cs.ids.loyaltyPlatform.model.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping(path = "loyaltyPlatform/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping
    public CampaignService add(@RequestBody Campaign campaign) {
        return this.campaignService.addCampaign(campaign);
    }

    @PatchMapping
    public Campaign updateCampaign(@RequestBody @Param("campaign") Campaign campaign) {
        return this.campaignService.updateCampaign(campaign);
    }

    @DeleteMapping("/delete/{name}")
    public Campaign deleteCampaign(String campaignName) {
        return this.campaignService.deleteCampaign(campaignName);
    }

    @GetMapping("")
    public Campaign getCampaign() {

    }

    // may not be necessary.
    public Campaign searchCampaign(String name) {
        return this.campaignService.getByName(name);
    }

    @GetMapping("")
    public List<Campaign> getAllCampaigns() {
        return this.campaignService.getAllCampaigns();
    }

}
