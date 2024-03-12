package dat3.adventureXP.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentDto {
    private Long id;
    private String name;
    private Long activityId;  // Use activity ID instead of the Activity object

    public EquipmentDto(Long id, String name, Long activityId) {
        this.id = id;
        this.name = name;
        this.activityId = activityId;
    }
}
