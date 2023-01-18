package it.unicam.cs.ids.loyaltyPlatform.model.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company addCompany(long id) {
        return this.repository.save(this.repository.getReferenceById(id));
    }

    public Optional<Company> getCompany(long id) {
        return this.repository.findById(id);
    }

    public List<Company> getAllCompanies() {
        return this.repository.findAll();
    }

    public boolean updateCompany(long id) {
        return this.repository.updateCompany(id);
    }

    public void deleteCompany(long id) {
        this.repository.deleteById(id);
    }

    public List<Company> findAll() {
        return this.repository.findAll();
    }
}
