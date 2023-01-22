package it.unicam.cs.ids.loyaltyPlatform.model.fidelityProgram;

import it.unicam.cs.ids.loyaltyPlatform.model.users.clients.Client;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Fidelity program based on levels
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class LevelFidelityProgram implements FidelityProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private @NonNull Long id;

    private @NonNull String name;
    private @NonNull List<Client> clients;
    private boolean activated = false;

    @Override
    public void personalizeFidelityProgram() {
        //TODO
    }

    @Override
    public void activateFidelityProgram() {
        this.activated = true;
    }

    @Override
    public void deactivateFidelityProgram() {
        this.activated = false;
    }

    @Override
    public void resetFidelityProgram() {
        for (Client client : clients) {
            //TODO reset client's digital card ??
        }
        this.clients.clear();
    }

    @Override
    public void addClient(Client client) {
        this.clients.add(client);
    }

    @Override
    public Long getFidelityProgramId() {
        return this.id;
    }

}
