package dat3.adventureXP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Reservation_Activities")
@IdClass(ReservationActivityId.class)
public class ReservationActivity {

    @Id
    @ManyToOne
    @JoinColumn(name = "reservation")
    private Reservation reservation;
    @Id
    @ManyToOne
    @JoinColumn(name = "activity")
    private Activity activity;
    private int startTime; // military time e.g. 1300 for 1:00 PM
    private int reservedSlots; // Number of slots reserved for this activity
    @CreationTimestamp
    private LocalDateTime created;

}
