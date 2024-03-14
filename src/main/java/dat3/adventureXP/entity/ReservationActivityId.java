package dat3.adventureXP.entity;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ReservationActivityId implements Serializable {

    @ManyToOne
    private Reservation reservation;

    @ManyToOne
    private Activity activity;
}