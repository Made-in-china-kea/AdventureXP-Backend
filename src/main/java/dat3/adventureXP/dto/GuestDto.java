package dat3.adventureXP.dto;
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

     public GuestDto(Long id, String name, String phoneNumber, String email) {
          this.id = id;
          this.name = name;
          this.phoneNumber = phoneNumber;
          this.email = email;
     }
}
