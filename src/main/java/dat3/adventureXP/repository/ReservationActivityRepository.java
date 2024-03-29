package dat3.adventureXP.repository;

import dat3.adventureXP.entity.ReservationActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationActivityRepository extends JpaRepository<ReservationActivity, Integer> {

    List<ReservationActivity> getReservationActivityByActivity_IdAndReservation_ReservationDate(Integer activityId, String date);
}
