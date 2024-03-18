package dat3.adventureXP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    private Guest guest;

    @ManyToOne
    private Company company;

    @Column(nullable = false)
    private Date reservationDate;

    @Column(nullable = false)
    private Time reservationTime;

    @Column(nullable = false)
    private Integer numberOfParticipants;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime edited;
    private boolean isCancelled;


    @OneToMany(mappedBy = "reservationId", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<ReservationActivity> reservedActivities = new HashSet<>();

    public void addActivity(ReservationActivity activity) {
         this.reservedActivities.add(activity);
    }
    public void cancelReservation() {
        this.isCancelled = true;
    }
}
