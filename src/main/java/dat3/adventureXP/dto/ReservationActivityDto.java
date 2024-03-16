package dat3.adventureXP.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventureXP.entity.Activity;
import dat3.adventureXP.entity.ReservationActivity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationActivityDto {

    private Integer reservationId;
    private Activity activity;
    private String date;
    private Integer startTime; // military time e.g. 1300 for 1:00 PM
    private Integer reservedSlots; // Number of slots reserved for this activity
    private LocalDateTime created;

    public ReservationActivityDto(ReservationActivity r) {
        this.activity = r.getActivity();
        this.reservationId = r.getReservationId();
        this.date = r.getDate();
        this.startTime = r.getStartTime();
        this.reservedSlots = r.getReservedSlots();
        this.created = r.getCreated();
    }
}