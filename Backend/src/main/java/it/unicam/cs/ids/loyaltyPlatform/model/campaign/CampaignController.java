package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/campaign")
@CrossOrigin("http://localhost:3000/")
public class CampaignController {

    @Autowired
    private CampaignServiceImpl campaignService;


    @GetMapping(path = "/get/{campaignId}")
    public Campaign getCampaign(@NonNull @PathVariable("campaignId") Long id) {
        return this.campaignService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Campaign> getAllCampaigns() {
        return this.campaignService.getAll();
    }


}
