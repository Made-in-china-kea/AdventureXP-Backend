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

    // Getters and setters are omitted for brevity
}
