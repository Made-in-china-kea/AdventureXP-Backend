package dat3.adventureXP.entity;

import dat3.adventureXP.dto.ReservationDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private LocalDateTime created;
    private LocalDateTime edited;
    private boolean isCancelled;


    @OneToMany(fetch = FetchType.EAGER)
    private Set<ReservationActivity> reservedActivities = new HashSet<>();


   public Reservation(ReservationDto r) {
       this.id = r.getId();
       this.reservationDate = r.getReservationDate();
       this.reservationTime = r.getReservationTime();
       this.numberOfParticipants = r.getNumberOfParticipants();
       this.created = r.getCreated();
       this.edited = r.getEdited();
       this.isCancelled = r.isCancelled();
       if (r.getGuest() != null) {
           this.guest = new Guest(r.getGuest());
       } else {
           this.company = new Company(r.getCompany());
       }

       this.reservedActivities = r.getReservedActivities();
   }

    public void addActivity(ReservationActivity activity) {
         this.reservedActivities.add(activity);
    }

}
