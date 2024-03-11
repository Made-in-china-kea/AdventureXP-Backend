package dat3.adventureXP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
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

    @ManyToOne
    private Company company;

    @Column(nullable = false)
    private Date reservationDate;

    @Column(nullable = false)
    private Time reservationTime;

    @Column(nullable = false)
    private Integer numberOfParticipants;

    @ManyToMany(mappedBy = "reservations")
    private Set<Activity> activities = new HashSet<>();

    // Getters, setters, and methods for adding/removing activities are omitted for brevity
}
