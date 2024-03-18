package dat3.adventureXP.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EquipmentDto {
    private int id;
    private String name;
    private int activityId;  // Use activity ID instead of the Activity object

    public EquipmentDto(int id, String name, int activityId) {
        this.id = id;
        this.name = name;
        this.activityId = activityId;
    }
}
