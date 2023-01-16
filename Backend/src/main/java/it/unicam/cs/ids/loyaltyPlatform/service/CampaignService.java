package it.unicam.cs.ids.loyaltyPlatform.service;

import it.unicam.cs.ids.loyaltyPlatform.model.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.repository.CampaignRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CampaignService {

    @Autowired
    private CampaignRepository repository;

    public Campaign updateCampaign(Campaign campaign) {
    }

    public List<Campaign> getAllCampaigns() {
    }

    public Campaign deleteCampaign(String campaignName) {
    }

    public Campaign getByName(String name) {
    }

    public CampaignService addCampaign(Campaign campaign) {
        return this.repository.save();
    }
}
