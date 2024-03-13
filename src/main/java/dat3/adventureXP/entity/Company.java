package dat3.adventureXP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Companies")
public class Company extends Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contactName;

    @Column(nullable = false, unique = true)
    private String contactEmail;

    private Integer cvr;
}