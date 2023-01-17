package it.unicam.cs.ids.loyaltyPlatform.model;

import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.Owner;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

/**
 * Class that defines a company in the platform
 */
@Getter
@Setter
public class Company {

    private @NonNull String name;
    private @NonNull Owner owner;
    private static long idSaver = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long refId;

    public Company(@NotNull String name, @NotNull Owner owner) {
        this.name = name;
        this.owner = owner;
        this.refId = Company.getNextRefId();
    }

    /**
     * Calculates next unique refId
     * @return the next unique refId
     */
    public static long getNextRefId(){
        long id = idSaver;
        idSaver++;
        return id;
    }
}
