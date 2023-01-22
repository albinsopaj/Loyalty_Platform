package it.unicam.cs.ids.loyaltyPlatform.model.company;

import lombok.NonNull;

import java.util.List;

public interface CompanyService {

    Company save(@NonNull Company company);

    Company saveById(@NonNull Long id);

    Company findById(@NonNull Long id);

    List<Company> getAll();

    Company update(Company company);

    Company updateById(@NonNull Long id);

    void delete(@NonNull Company company);

    void deleteById(@NonNull Long id);


}
