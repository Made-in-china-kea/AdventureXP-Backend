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

    public ReservationController(ReservationService reservationService, ReservationActivityService reservationActivityService) {
        this.reservationService = reservationService;
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
    public ReservationDto getReservationById(@PathVariable int id) {
        return reservationService.getReservationById(id);
    }

    // Update (PUT)
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@PathVariable int id, @RequestBody ReservationDto request) {
        return reservationService.editReservation(id, request);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<ReservationDto> cancelReservation(@PathVariable int id) {
        return reservationService.cancelReservation(id);
    }
}
