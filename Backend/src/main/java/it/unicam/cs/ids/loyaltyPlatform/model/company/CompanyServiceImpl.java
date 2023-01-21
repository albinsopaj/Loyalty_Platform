package it.unicam.cs.ids.loyaltyPlatform.model.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company save(Company company) {
        return this.repository.save(company);
    }

    @Override
    public Company saveById(UUID id) {
        Company comp = this.findById(id);
        return this.repository.save(comp);
    }

    @Override
    public Company findById(UUID id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found"));
    }

    @Override
    public List<Company> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Company update(Company company) {
        //TODO implement business logic here
        return this.repository.save(company);
    }

    @Override
    public Company updateById(UUID id) {

        Optional<Company> oldCompany = this.repository.findById(id);

        if (oldCompany.isPresent()) {
            Company orgCompany = oldCompany.get();
            return this.repository.save(orgCompany);
        }
        return null;
    }

    @Override
    public void delete(Company company) {
        this.repository.delete(company);
    }

    @Override
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }

}
