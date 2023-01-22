package it.unicam.cs.ids.loyaltyPlatform.model.company;

import java.util.List;
import java.util.UUID;

public interface CompanyService {

    Company save(Company company);

    Company saveById(UUID id);

    Company findById(UUID id);

    List<Company> getAll();

    Company update(Company company);

    Company updateById(UUID id);

    void delete(Company company);

    void deleteById(UUID id);


}
