package dat3.adventureXP.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.adventureXP.entity.ReservationActivity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActivityReservationDto {

    private Integer activityId;
    private Integer reservationId;
    private Integer startTime;
    private Integer endTime;

    private LocalDateTime created;

    public ActivityReservationDto(ReservationActivity reservationActivity) {
        this.activityId = reservationActivity.getActivity().getId();
        this.reservationId = reservationActivity.getReservation().getId();
        this.startTime = reservationActivity.getStartTime();
        this.endTime = reservationActivity.getEndTime();
        this.created = reservationActivity.getCreated();
    }
}