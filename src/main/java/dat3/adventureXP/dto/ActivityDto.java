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

     private Integer id;
     private String name;
     private Integer price;
     private Integer ageLimit;
     private Integer timeSlot;

     public ActivityDto(Activity a) {
        this.id = a.getId();
        this.name = a.getName();
        this.ageLimit = a.getAgeLimit();
        this.timeSlot = a.getTimeSlot();
        this.price = a.getPrice();
     }
}