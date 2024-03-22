package dat3.adventureXP.entity;

import dat3.adventureXP.dto.GuestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;
    @CreationTimestamp
    private LocalDateTime created;

    @OneToMany(mappedBy = "guest", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Reservation> reservations;

    public Guest(GuestDto guest) {
        this.firstName = guest.getFirstName();
        this.lastName = guest.getLastName();
        this.email = guest.getEmail();
        this.created = LocalDateTime.now();
    }
}
