package dat3.adventureXP.api;

import dat3.adventureXP.repository.ReservationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Similar CRUD operations as in ActivityController (adjust for Reservation entity)

    // Additional method for adding activities to a reservation (assuming a method in Reservation to add Activity)
    @PostMapping("/{reservationId}/activities/{activityId}")
    public ResponseEntity<?> addActivityToReservation(@PathVariable Long reservationId, @PathVariable Long activityId) {
        // Implement logic to add activity to the reservation
        return ResponseEntity.ok().build();
    }
}
