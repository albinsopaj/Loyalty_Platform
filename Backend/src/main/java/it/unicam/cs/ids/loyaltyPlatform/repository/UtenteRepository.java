package it.unicam.cs.ids.loyaltyPlatform.repository;

import it.unicam.cs.ids.loyaltyPlatform.model.UtenteAutenticato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Interfaccia per gestire tutte le operazioni CRUD sul repository del {@link UtenteAutenticato}.
 */
@Repository
public interface UtenteRepository extends JpaRepository<UtenteAutenticato, UUID> {

    @Query("SELECT u FROM UtenteAutenticato u WHERE u.email = :email")
    UtenteAutenticato getUserByUsername(@Param("email") String email);

    @Query("SELECT u FROM ...");
    UtenteAutenticato findByUsername(@Param("username") String username);
}
