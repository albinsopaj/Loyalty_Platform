package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram.points.PointsFidelityProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface to manage all CRUD operations on the repository of {@link PointsFidelityProgram}.
 */
@NoRepositoryBean
public interface FidelityProgramRepository<T extends FidelityProgram, Long> extends JpaRepository<T, Long> {

}
