package it.unicam.cs.ids.loyaltyPlatform.model.campaign;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

/**
 * Class that defines a campaign
 */
@Getter
@Setter
public class Campaign {

    private @NonNull String name;
    private @NonNull @Id UUID campaignId;
    private @NonNull Date start;
    private @NonNull Date end;

    public Campaign(@NotNull String name, @NotNull Date start, @NotNull Date end) {
        this.campaignId = UUID.randomUUID();
        this.name = name;
        this.start = start;
        this.end = end;
    }
}
