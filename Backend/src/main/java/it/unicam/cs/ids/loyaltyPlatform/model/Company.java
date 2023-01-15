package it.unicam.cs.ids.loyaltyPlatform.model;

import it.unicam.cs.ids.loyaltyPlatform.model.users.workers.Owner;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 * Class that defines a company in the platform
 */
@Getter
@Setter
public class Company {

    private @NonNull String name;
    private @NonNull Owner owner;
    private @NonNull @Id long refId;
    private static @NonNull long idSaver = 0;

    public Company(String name, Owner owner){
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
