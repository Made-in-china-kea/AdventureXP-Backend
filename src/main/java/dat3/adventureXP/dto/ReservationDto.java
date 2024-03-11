package dat3.adventureXP.dto;

import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
     Long id;
     GuestDto guest;  // Use GuestDto instead of Guest
     CompanyDto company;  // Use CompanyDto instead of Company
     Date reservationDate;
     Time reservationTime;
     Integer numberOfParticipants;
}
