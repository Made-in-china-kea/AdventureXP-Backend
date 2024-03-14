package dat3.adventureXP.entity;

import dat3.adventureXP.dto.GuestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    private LocalDateTime created;

    public Guest(GuestDto guest) {
        this.firstName = guest.getFirstName();
        this.lastName = guest.getLastName();
        this.phoneNumber = guest.getPhoneNumber();
        this.email = guest.getEmail();
        this.created = LocalDateTime.now();
    }
}
