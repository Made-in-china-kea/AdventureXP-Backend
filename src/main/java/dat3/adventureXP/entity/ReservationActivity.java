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
    private int reservationId;  // Use primitive for primary key field
    @Id
    @ManyToOne
    private Activity activity;
    private String date;
    private int startTime; // military time e.g. 1300 for 1:00 PM
    private int reservedSlots; // Number of slots reserved for this activity
    @CreationTimestamp
    private LocalDateTime created;

}
