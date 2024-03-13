package dat3.adventureXP.entity;

import dat3.adventureXP.dto.GuestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "guest", cascade = CascadeType.ALL)
    private Company company;
}
