package dat3.adventureXP.dto;

import java.sql.Time;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDto {
     private Long id;
     private GuestDto guest;  // Use GuestDto instead of Guest
     private CompanyDto company;  // Use CompanyDto instead of Company
     private Date reservationDate;
     private Time reservationTime;
     private Integer numberOfParticipants;


     public ReservationDto(Long id, GuestDto guest, CompanyDto company, Date reservationDate, Time reservationTime, Integer numberOfParticipants) {
          this.id = id;
          this.guest = guest;
          this.company = company;
          this.reservationDate = reservationDate;
          this.reservationTime = reservationTime;
          this.numberOfParticipants = numberOfParticipants;
     }
}
