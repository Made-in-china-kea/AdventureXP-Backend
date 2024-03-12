package dat3.adventureXP.dto;
import dat3.adventureXP.entity.Guest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestDto {
     private Long id;
     private String name;
     private String phoneNumber;
     private String email;

     public GuestDto(Guest g) {
         this.id = g.getId();
         this.name = g.getName();
         this.phoneNumber = g.getPhoneNumber();
         this.email = g.getEmail();
     }
}
