package dat3.adventureXP.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentDto {
    private Integer id;
    private String name;
    private Integer activityId;  // Use activity ID instead of the Activity object

    public EquipmentDto(Integer id, String name, Integer activityId) {
        this.id = id;
        this.name = name;
        this.activityId = activityId;
    }
}
