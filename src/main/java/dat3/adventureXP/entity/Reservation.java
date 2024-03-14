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


    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    @JoinTable(name = "reservation_activities",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private Set<ReservationActivity> activities = new HashSet<>();


   public Reservation(ReservationDto reservationDto) {
       this.id = reservationDto.getId();
       this.reservationDate = reservationDto.getReservationDate();
       this.reservationTime = reservationDto.getReservationTime();
       this.numberOfParticipants = reservationDto.getNumberOfParticipants();
       this.created = reservationDto.getCreated();
       this.edited = reservationDto.getEdited();
       if (reservationDto.getGuest() != null) {
           this.guest = new Guest(reservationDto.getGuest());
       } else {
           this.company = new Company(reservationDto.getCompany());
       }
   }

}
