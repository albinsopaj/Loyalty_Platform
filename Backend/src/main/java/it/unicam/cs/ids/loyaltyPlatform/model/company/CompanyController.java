package it.unicam.cs.ids.loyaltyPlatform.model.company;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("loyaltyPlatform/campaign")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl service;

    @PostMapping("/company")
    public Company addCompany(@RequestBody UUID id) {
        return this.service.saveById(id);
    }

    @GetMapping("company/{id}")
    public Company getCompany(@NonNull @PathVariable("id") UUID id) {
        return this.service.findById(id);
    }

    @GetMapping("companies")
    public List<Company> getAllCompanies() {
        return this.service.getAll();
    }

    @PutMapping("/update/{company}")
    public Company updateCompany(@RequestBody @PathVariable Company company) {
        return this.service.update(company);
    }

    @DeleteMapping("delete/{company}")
    public void deleteCampaign(@NonNull @PathVariable Company company) {
        this.service.delete(company);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCompany(@NonNull @PathVariable("id") UUID id) {
        this.service.deleteById(id);
    }

}
