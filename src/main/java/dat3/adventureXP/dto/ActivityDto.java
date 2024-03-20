package dat3.adventureXP.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventureXP.entity.Activity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityDto {

     private int id;
     private String name;
     private double price;
     private int ageLimit;
     private int timeSlot; // 1 hour = 100, 2 hours = 200, 3 hours = 300, etc.

     public ActivityDto(Activity a) {
        this.id = a.getId();
        this.name = a.getName();
        this.ageLimit = a.getAgeLimit();
        this.timeSlot = a.getTimeSlot();
        this.price = a.getPrice();
     }
}