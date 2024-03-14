package dat3.adventureXP.api;

import dat3.adventureXP.dto.ReservationDto;
import dat3.adventureXP.entity.Reservation;
import dat3.adventureXP.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")  // Adjusted base path
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Create (POST)
    @PostMapping
    public ReservationDto createReservation(@RequestBody ReservationDto request){
        return reservationService.createReservation(request);
    }
    // Read All (GET)
    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // Read by ID (GET)
    @GetMapping("/{id}")
    public ReservationDto getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    // Update (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@PathVariable Long id, @RequestBody ReservationDto request) {
        return reservationService.editReservation(id, request);
    }

    // Delete (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable Long id) {
        return reservationService.deleteReservation(id);
    }
}
