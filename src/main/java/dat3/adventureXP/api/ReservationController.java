package dat3.adventureXP.api;

import dat3.adventureXP.dto.ReservationDto;
import dat3.adventureXP.service.ReservationActivityService;
import dat3.adventureXP.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")  // Adjusted base path
public class ReservationController {

    private final ReservationService reservationService;

    private final ReservationActivityService reservationActivityService;

    public ReservationController(ReservationService reservationService, ReservationActivityService reservationActivityService) {
        this.reservationService = reservationService;
        this.reservationActivityService = reservationActivityService;
    }

    // Create (POST)
    @PostMapping
    public ReservationDto createReservation(@RequestBody ReservationDto request){
        return reservationService.createReservation(request);
    }
    // Read All (GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<ReservationDto> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // Read by ID (GET)
    @GetMapping("/{id}")
    public ReservationDto getReservationById(@PathVariable Integer id) {
        return reservationService.getReservationById(id);
    }

    // Update (PUT)
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@PathVariable Integer id, @RequestBody ReservationDto request) {
        return reservationService.editReservation(id, request);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<ReservationDto> cancelReservation(@PathVariable Integer id) {
        return reservationService.cancelReservation(id);
    }

    @GetMapping("/{date}/{activityId}/availableslots")
    public List<Integer> getAvailableSlots(@PathVariable String date, @PathVariable Integer activityId) {
        return reservationActivityService.getAvailableSpots(date, activityId);
    }
}
