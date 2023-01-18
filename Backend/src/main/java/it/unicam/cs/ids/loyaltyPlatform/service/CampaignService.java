package it.unicam.cs.ids.loyaltyPlatform.service;

import it.unicam.cs.ids.loyaltyPlatform.model.campaign.Campaign;
import it.unicam.cs.ids.loyaltyPlatform.repository.CampaignRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class CampaignService {

    @Autowired
    private CampaignRepository repository;

    public Campaign addCampaign(Campaign campaign) {
        return this.repository.save(campaign);
    }

    public Optional<Campaign> searchCampaign(@NonNull UUID id) {
        return this.repository.findById(id);
    }

    public List<Campaign> getAllCampaigns() {
        return this.repository.findAll();
    }

    public Optional<Campaign> updateCampaign(@NonNull UUID campaignId) {
        return this.repository.findById(campaignId);
    }

    public void deleteCampaign(@NonNull UUID campaignId) {
        this.repository.deleteById(campaignId);
    }
}
