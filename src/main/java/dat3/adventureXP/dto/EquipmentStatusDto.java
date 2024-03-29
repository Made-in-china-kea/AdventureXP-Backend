package dat3.adventureXP.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class EquipmentStatusDto {
    private int id;
    private int equipmentId;  // Use equipment ID instead of the Equipment object
    private EquipmentStatusType status;
    private Date date;

    public EquipmentStatusDto(int id, Integer equipmentId, EquipmentStatusType status, Date date) {
        this.id = id;
        this.equipmentId = equipmentId;
        this.status = status;
        this.date = date;
    }

    public enum EquipmentStatusType {
        AVAILABLE,
        IN_USE,
        DAMAGED,
        UNDER_MAINTENANCE
    }
}
