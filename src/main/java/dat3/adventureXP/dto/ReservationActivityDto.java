package dat3.adventureXP.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventureXP.entity.Activity;
import dat3.adventureXP.entity.Reservation;
import dat3.adventureXP.entity.ReservationActivity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationActivityDto {

    private Reservation reservation;
    private Activity activity;
    private String date;
    private int startTime; // military time e.g. 1300 for 1:00 PM
    private int reservedSlots; // Number of slots reserved for this activity
    private LocalDateTime created;

    public ReservationActivityDto(ReservationActivity r) {
        this.activity = r.getActivity();
        this.reservation = r.getReservation();
        this.startTime = r.getStartTime();
        this.reservedSlots = r.getReservedSlots();
        this.created = r.getCreated();
    }
}