package dat3.adventureXP.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventureXP.entity.Activity;
import dat3.adventureXP.entity.Reservation;
import dat3.adventureXP.entity.ReservationActivity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationActivityDto {

    private Reservation reservation;
    private Activity activity;
    private Integer startTime;
    private Integer reservedSlots;
    private Integer endTime;

    private LocalDateTime created;

    public ReservationActivityDto(ReservationActivity r) {
        this.activity = r.getActivity();
        this.reservation = r.getReservation();
        this.startTime = r.getStartTime();
        this.reservedSlots = r.getReservedSlots();
        this.endTime = r.getEndTime();
        this.created = r.getCreated();
    }

}