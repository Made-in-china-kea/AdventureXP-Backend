package dat3.adventureXP.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
     Long id;
     String name;
     String phoneNumber;
     String email;
}
