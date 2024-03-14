package dat3.adventureXP.dto;
import dat3.adventureXP.entity.Guest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestDto {
     private Integer id;
     private String firstName;
     private String lastName;
     private String phoneNumber;
     private String email;

     public GuestDto(Guest g) {
         this.id = g.getId();
         this.firstName = g.getFirstName();
         this.lastName = g.getLastName();
         this.phoneNumber = g.getPhoneNumber();
         this.email = g.getEmail();
     }


}
