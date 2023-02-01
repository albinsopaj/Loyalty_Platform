package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.manager;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
