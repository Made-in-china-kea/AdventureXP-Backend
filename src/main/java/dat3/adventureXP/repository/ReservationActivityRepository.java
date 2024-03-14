package dat3.adventureXP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationActivityRepository extends JpaRepository<ReservationActivityRepository, Integer> {

    Optional<ReservationActivityRepository> findByReservationId(Integer reservationId);

    Optional<ReservationActivityRepository> deleteByReservationId(Integer reservationId);
}
