package dat3.adventureXP.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("BASE") // Prevent direct instantiation
@DiscriminatorColumn(name = "customer_type") // Discriminator column
public abstract class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
    private CustomerType customerType;
    public enum CustomerType {
        GUEST,
        COMPANY
    }


}
