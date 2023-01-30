package it.unicam.cs.ids.loyaltyPlatform.model.company;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loyaltyPlatform/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl service;

    @PostMapping(path = "/add/{company}")
    public Company addCompany(@NonNull @RequestBody @PathVariable("company") Company company) {
        return this.service.save(company);
    }

    @GetMapping(path = "/get/{id}")
    public Company getCompany(@NonNull @PathVariable("id") Long id) {
        return this.service.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Company> getAllCompanies() {
        return this.service.getAll();
    }

    @PutMapping(path = "/update/{company}")
    public Company updateCompany(@NonNull @RequestBody @PathVariable Company company) {
        return this.service.update(company);
    }

    @DeleteMapping(path = "/delete/{company}")
    public void deleteCampaign(@NonNull @PathVariable Company company) {
        this.service.delete(company);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCompany(@NonNull @PathVariable("id") Long id) {
        this.service.deleteById(id);
    }

}
