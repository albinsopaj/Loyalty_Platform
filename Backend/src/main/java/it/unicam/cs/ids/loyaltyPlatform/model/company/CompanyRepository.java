package it.unicam.cs.ids.loyaltyPlatform.model.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    boolean updateCompany(long id);


}