package dat3.adventureXP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Reservation_Activities")
public class ReservationActivity {

    @Id
    @ManyToOne
    private Reservation reservation;

    @Id
    @ManyToOne
    private Activity activity;

    private Integer startTime;

    private Integer endTime = startTime + activity.getTimeSlot();

    private LocalDateTime created;

    public ReservationActivity(ReservationActivity reservationActivity) {
        this.reservation = reservationActivity.getReservation();
        this.activity = reservationActivity.getActivity();
        this.startTime = reservationActivity.getStartTime();
        this.endTime = reservationActivity.getEndTime();
        this.created = reservationActivity.getCreated();
    }
}
