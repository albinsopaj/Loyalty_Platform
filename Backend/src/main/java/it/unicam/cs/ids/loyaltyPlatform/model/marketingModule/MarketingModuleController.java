package it.unicam.cs.ids.loyaltyPlatform.model.marketingModule;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "loyaltyPlatform/marketingModule")
public class MarketingModuleController {
    @Autowired
    private MarketingModuleServiceImpl marketingModuleService;

    @PostMapping(path = "/add")
    public MarketingModule addMarketingModule(@NonNull @RequestBody MarketingModule marketingModule) {
        return this.marketingModuleService.save(marketingModule);
    }

    @GetMapping(path = "/get/{id}")
    public MarketingModule getMarketingModule(@NonNull @PathVariable Long id) {
        return this.marketingModuleService.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<MarketingModule> getAllMarketingModules() {
        return this.marketingModuleService.getAll();
    }

    @PutMapping(path = "/update/{marketingModule}")
    public MarketingModule updateMarketingModule(@NonNull @RequestBody @PathVariable("marketingModule") MarketingModule marketingModule) {
        return this.marketingModuleService.update(marketingModule);
    }

    @PostMapping(path = "/{digitalCardId}/{value}")
    public void updateDigitalCardStatus(@NonNull @PathVariable("digitalCardId") Long id, @PathVariable int value) {
        //this.digitalCardService.findById(id).updateStatus(value);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteMarketingModule(@NonNull @PathVariable("id") Long id) {
        this.marketingModuleService.deleteById(id);
    }

    @DeleteMapping(path = "delete/{marketingModule}")
    public void deleteMarketingModule(@NonNull @PathVariable MarketingModule marketingModule) {
        this.marketingModuleService.delete(marketingModule);
    }

}
