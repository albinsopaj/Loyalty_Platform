package it.unicam.cs.ids.loyaltyPlatform.model.marketingModule;

import it.unicam.cs.ids.loyaltyPlatform.model.cardSystem.DigitalCardService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/marketingModule")
public class MarketingModuleController {
    @Autowired
    private MarketingModuleService marketingModuleService;

    @Autowired
    private DigitalCardService digitalCardService;

    @PostMapping("/marketingModule")
    public MarketingModule addMarketingModule(@NonNull @RequestBody MarketingModule marketingModule) {
        return this.marketingModuleService.save(marketingModule);
    }

    @GetMapping("marketingModule/{id}")
    public MarketingModule getMarketingModule(@NonNull @PathVariable Long id) {
        return this.marketingModuleService.findById(id);
    }

    @GetMapping("/marketingModules")
    public List<MarketingModule> getAllMarketingModules() {
        return this.marketingModuleService.getAll();
    }

    @PutMapping("/update/{marketingModule}")
    public MarketingModule updateMarketingModule(@NonNull @RequestBody @PathVariable("MarketingModule") MarketingModule marketingModule) {
        return this.marketingModuleService.update(marketingModule);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMarketingModule(@NonNull @PathVariable("id") Long id) {
        this.marketingModuleService.deleteById(id);
    }

    @DeleteMapping("delete/{marketingModule}")
    public void deleteMarketingModule(@NonNull @PathVariable MarketingModule marketingModule) {
        this.marketingModuleService.delete(marketingModule);
    }

    @PostMapping("/marketingModule/{digitalCardId}/{value}")
    public void updateDigitalCardStatus(@NonNull @PathVariable Long id, @NonNull @PathVariable int value){
        this.digitalCardService.findById(id).updateStatus(value);
    }

}
