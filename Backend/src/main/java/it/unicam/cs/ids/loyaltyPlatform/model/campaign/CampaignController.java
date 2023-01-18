package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Controller
@RequestMapping(path = "loyaltyPlatform/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping
    public Campaign addCampaign(@RequestBody Campaign campaign) {
        return this.campaignService.addCampaign(campaign);
    }

    @GetMapping("")
    public Optional<Campaign> searchCampaign(@NonNull UUID id) {
        return this.campaignService.searchCampaign(id);
    }

    @GetMapping("")
    public List<Campaign> getAllCampaigns() {
        return this.campaignService.getAllCampaigns();
    }

    @PatchMapping
    public Optional<Campaign> updateCampaign(@RequestBody @Param("campaign") UUID campaignId) {
        return this.campaignService.updateCampaign(campaignId);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteCampaign(@NonNull UUID campaignId) {
        this.campaignService.deleteCampaign(campaignId);
    }

}
