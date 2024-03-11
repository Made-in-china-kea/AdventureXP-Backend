package dat3.adventureXP.dto;

import dat3.adventureXP.entity.EquipmentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentStatusDto {
     Long id;
     Long equipmentId;  // Use equipment ID instead of the Equipment object
     EquipmentStatus status;
     Date date;
     enum EquipmentStatusType {
        AVAILABLE,
        IN_USE,
        DAMAGED,
        UNDER_MAINTENANCE
    }
}
