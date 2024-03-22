package dat3.adventureXP.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ReservationActivityId implements Serializable {
    private Integer reservation;
    private Integer activity;

    public ReservationActivityId(Integer reservation, Integer activity) {
        this.reservation = reservation;
        this.activity = activity;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReservationActivityId)) return false;
        ReservationActivityId that = (ReservationActivityId) o;
        return reservation.equals(that.reservation) && activity.equals(that.activity);
    }

    @Override
    public int hashCode() {
        return reservation.hashCode() + activity.hashCode();
    }
}