package it.unicam.cs.ids.loyaltyPlatform.model.company;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081"}, maxAge = 3600)
@RestController
@RequestMapping("loyaltyPlatform/company")
public class CompanyController {

    @Autowired
    private CompanyServiceImpl service;

    @GetMapping(path = "/get/{id}")
    public Company getCompany(@NonNull @PathVariable("id") Long id) {
        return this.service.findById(id);
    }

    @GetMapping(path = "/getAll")
    public List<Company> getAllCompanies() {
        return this.service.getAll();
    }

}
