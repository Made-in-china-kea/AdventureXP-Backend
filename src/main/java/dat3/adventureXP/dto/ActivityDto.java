package dat3.adventureXP.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventureXP.entity.Activity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityDto {

     private Long id;
     private String name;
     private Integer ageLimit;
     private Integer timeSlot;

     public ActivityDto(Activity activity) {
            this.id = activity.getId();
            this.name = activity.getName();
            this.ageLimit = activity.getAgeLimit();
            this.timeSlot = activity.getTimeSlot();
     }
}