package dat3.adventureXP.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventureXP.entity.Reservation;
import dat3.adventureXP.entity.ReservationActivity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDto {
     private Integer id;
     private GuestDto guest;
     private CompanyDto company;
     private String reservationDate;
     private int numberOfParticipants;
     private LocalDateTime created;
     private LocalDateTime edited;
     private Set<ReservationActivity> reservedActivities;
     private boolean isCancelled;


     public ReservationDto(Reservation r ) {
         this.id = r.getId();
         this.reservationDate = r.getReservationDate();
         this.numberOfParticipants = r.getNumberOfParticipants();
         this.created = r.getCreated();
         this.edited = r.getEdited();
         this.reservedActivities = r.getReservedActivities();
         this.isCancelled = r.isCancelled();
         if (r.getGuest() != null) {
             this.guest = new GuestDto(r.getGuest());
         } else if (r.getCompany() != null){
             this.company = new CompanyDto(r.getCompany());
         }
     }
}
