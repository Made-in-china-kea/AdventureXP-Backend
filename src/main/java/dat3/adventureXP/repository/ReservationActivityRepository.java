package dat3.adventureXP.repository;

import dat3.adventureXP.entity.ReservationActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationActivityRepository extends JpaRepository<ReservationActivity, Integer> {
    Optional<ReservationActivity> findByActivityId(Integer activityId);


    List<ReservationActivity> getReservedActivities(String date, Integer activityId);
}
