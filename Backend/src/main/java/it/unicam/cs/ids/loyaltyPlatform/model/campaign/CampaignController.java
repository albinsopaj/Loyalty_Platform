package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/campaign")
public class CampaignController {

    @Autowired
    private CampaignServiceImpl campaignService;

//    @PostMapping(path = "/add")
//    public Campaign addCampaign(@RequestBody @Param("campaign") Campaign campaign) {
//        return this.campaignService.save(campaign);
//    }

    @GetMapping(path = "/get/{campaignId}")
    public Campaign getCampaign(@NonNull @PathVariable("campaignId") Long id) {
        return this.campaignService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Campaign> getAllCampaigns() {
        return this.campaignService.getAll();
    }

//    @PutMapping(path = "/update/{campaignId}")
//    public Campaign updateCampaign(@NonNull @PathVariable("campaignId") Long id, @RequestBody Campaign campaign) {
//        return this.campaignService.update(campaign);
//    }
//
//    @DeleteMapping(path = "/delete/{campaignId}")
//    public void deleteCampaign(@NonNull @PathVariable("campaignId") Long id) {
//        this.campaignService.deleteById(id);
//    }
//
//    @DeleteMapping(path = "/delete")
//    public void deleteCampaign(@NonNull @Param("campaign") Campaign campaign) {
//        this.campaignService.delete(campaign);
//    }

}
