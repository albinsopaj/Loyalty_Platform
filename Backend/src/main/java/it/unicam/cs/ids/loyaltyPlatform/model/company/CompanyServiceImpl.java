package it.unicam.cs.ids.loyaltyPlatform.model.company;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository repository;

    public Company save(@NonNull Company company) {
        if (!this.repository.existsById(company.getId())) {
            this.repository.save(company);
            return company;
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Company is already present!");
    }

    @Override
    public Company saveById(@NonNull Long id) {
        if (!this.repository.existsById(id)) {
            return this.repository.save(this.findById(id));
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company already exists!");
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
    public Company update(@NonNull Company company) {
        if (this.repository.existsById(company.getId())) {
            this.repository.save(company);
            return company;
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campaign does not exist!");
    }

    @Override
    public Company updateById(@NonNull Long id) {
        if (this.repository.existsById(id)) {
            this.repository.save(findById(id));
            return findById(id);
        } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trying to update non-existing campaign!");
    }

    @Override
    public void delete(@NonNull Company company) {
        for (Company c : this.repository.findAll()) {
            if (this.repository.existsById(c.getId())) {
                this.repository.delete(company);
            } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found");
        }
    }

    @Override
    public void deleteById(@NonNull Long id) {
        if (this.repository.findById(id).isPresent()) {
            this.repository.deleteById(id);
            System.out.println("Campaign deleted successfully");
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Campaign not found");
    }

}
