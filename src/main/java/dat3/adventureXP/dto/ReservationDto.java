package dat3.adventureXP.dto;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import dat3.adventureXP.entity.Activity;
import dat3.adventureXP.entity.Reservation;
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
     private LocalDateTime created;
     private LocalDateTime edited;
     private Set<Activity> activities;


     public ReservationDto(Reservation r ) {
         this.id = r.getId();
         this.reservationDate = r.getReservationDate();
         this.reservationTime = r.getReservationTime();
         this.numberOfParticipants = r.getNumberOfParticipants();
         this.created = r.getCreated();
         this.edited = r.getEdited();
         if(r.getGuest() != null){
            this.guest = new GuestDto(r.getGuest());
         } else {
            this.company = new CompanyDto(r.getCompany());
         }
     }

    public Long getGuestId() {
         return guest.getId();
    }

    public Long getCompanyId() {
         return company.getId();
    }
}
