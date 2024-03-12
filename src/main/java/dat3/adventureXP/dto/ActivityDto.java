package dat3.adventureXP.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActivityDto {

     private Long id;
     private String name;
     private Integer ageLimit;
     private Integer timeSlot;

     public ActivityDto(Long id, String name, Integer ageLimit, Integer timeSlot) {
          this.id = id;
          this.name = name;
          this.ageLimit = ageLimit;
          this.timeSlot = timeSlot;
     }
}