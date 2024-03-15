package dat3.adventureXP.entity;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ReservationActivityId implements Serializable {

    private Integer reservationId;
    @ManyToOne
    private Activity activity;
}