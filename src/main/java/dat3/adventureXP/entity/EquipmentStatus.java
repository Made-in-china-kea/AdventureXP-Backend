package dat3.adventureXP.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Equipment_Status")
public class EquipmentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Equipment equipment;

    @Enumerated(EnumType.STRING)
    private EquipmentStatusType status;

    @Column(nullable = false)
    private Date date;

    public enum EquipmentStatusType {
        AVAILABLE,
        IN_USE,
        DAMAGED,
        UNDER_MAINTENANCE
    }
}