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
@IdClass(ReservationActivityId.class)
public class ReservationActivity {

    @Id
    private Integer reservationId;  // Use primitive for primary key field
    @Id
    @ManyToOne
    private Activity activity;
    private String date;
    private Integer startTime;
    private Integer reservedSlots;
    private Integer endTime = startTime + (activity.getTimeSlot() * reservedSlots);
    private LocalDateTime created;

}
