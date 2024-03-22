package dat3.adventureXP.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false)
    private String reservationDate; // Use LocalDate for date

    @Column(nullable = false)
    private int numberOfParticipants;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ReservationActivity> reservedActivities = new HashSet<>();

    private boolean isCancelled;

    public void addActivity(ReservationActivity activity) {
        this.reservedActivities.add(activity);
    }

    public void cancelReservation() {
        this.isCancelled = true;
    }
}
