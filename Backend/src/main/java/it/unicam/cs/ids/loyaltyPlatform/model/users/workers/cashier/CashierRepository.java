package it.unicam.cs.ids.loyaltyPlatform.model.users.workers.cashier;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRepository extends JpaRepository<Cashier, Long> {

}
