package it.unicam.cs.ids.loyaltyPlatform.model.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
public class CompanyController {

    @Autowired
    private CompanyService service;

    public Company addCompany(long id) {
        return this.service.addCompany(id);
    }

    public Optional<Company> getCompany(long id) {
        return this.service.getCompany(id);
    }

    public List<Company> getAllCompanies() {
        return this.service.findAll();
    }

    public boolean updateCompany(long id) {
        return this.service.updateCompany(id);
    }

    public void deleteCompany(long id) {
        this.service.deleteCompany(id);
    }

}
