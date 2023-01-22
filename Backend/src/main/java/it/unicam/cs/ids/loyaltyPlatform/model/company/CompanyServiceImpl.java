package it.unicam.cs.ids.loyaltyPlatform.model.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company save(@NonNull Company company) {
        return this.repository.save(company);
    }

    @Override
    public Company saveById(@NonNull Long id) {
        Company comp = this.findById(id);
        return this.repository.save(comp);
    }

    @Override
    public Company findById(@NonNull Long id) {
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
    public Company updateById(@NonNull Long id) {

        Optional<Company> oldCompany = this.repository.findById(id);

        if (oldCompany.isPresent()) {
            Company orgCompany = oldCompany.get();
            return this.repository.save(orgCompany);
        }
        return null;
    }

    @Override
    public void delete(@NonNull Company company) {
        this.repository.delete(company);
    }

    @Override
    public void deleteById(@NonNull Long id) {
        this.repository.deleteById(id);
    }

}
