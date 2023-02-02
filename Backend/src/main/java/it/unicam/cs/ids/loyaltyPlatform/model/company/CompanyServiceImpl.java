package it.unicam.cs.ids.loyaltyPlatform.model.company;

import it.unicam.cs.ids.loyaltyPlatform.model.util.GeneralService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements GeneralService<Company> {

    @Autowired
    private CompanyRepository repository;

    @Override
    public Company save(@NonNull Company company) {
        if (!repository.findAll().contains(company)) {
            return this.repository.save(company);
        } else throw new ResponseStatusException(HttpStatus.FOUND, "Company is already present!");
    }

    @Override
    public Company findById(@NonNull Long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));
    }

    @Override
    public Optional<Company> get(@NonNull Company company) {
        return this.repository.findById(company.getId());
    }

    @Override
    public List<Company> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Company update(@NonNull Company company) {
        return this.repository.save(company);
    }

    @Override
    public Company updateById(@NonNull Long id) {
        return this.repository.save(this.repository.getReferenceById(id));
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
