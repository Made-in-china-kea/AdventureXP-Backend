package dat3.adventureXP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Guest guest;

    @Column(nullable = false)
    private Date reservationDate;

    @Column(nullable = false)
    private Time reservationTime;

    @Column(nullable = false)
    private Integer numberOfParticipants;

    private LocalDateTime created;
    private LocalDateTime edited;

   @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Set<ReservationActivity> activities = new HashSet<>();
}
