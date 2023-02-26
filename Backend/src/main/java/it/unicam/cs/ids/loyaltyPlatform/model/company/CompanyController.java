package it.unicam.cs.ids.loyaltyPlatform.model.company;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loyaltyPlatform/company")
@CrossOrigin("http://localhost:3000/")
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
