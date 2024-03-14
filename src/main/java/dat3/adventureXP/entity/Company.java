package dat3.adventureXP.entity;

import dat3.adventureXP.dto.CompanyDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Companies")
public class Company{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String companyName;

    private String contactName;

    @Column(nullable = false, unique = true)
    private String contactEmail;

    @Column(nullable = false, unique = true)
    private Integer cvr;

    private LocalDateTime created;

    public Company(CompanyDto company) {
        this.companyName = company.getCompanyName();
        this.contactName = company.getContactName();
        this.contactEmail = company.getContactEmail();
        this.cvr = company.getCvr();
        this.created = LocalDateTime.now();
    }

}