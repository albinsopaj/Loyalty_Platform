package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FidelityProgramReviewRepository extends JpaRepository<FidelityProgramReview, Long> {
}
