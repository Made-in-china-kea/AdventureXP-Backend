package dat3.adventureXP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
