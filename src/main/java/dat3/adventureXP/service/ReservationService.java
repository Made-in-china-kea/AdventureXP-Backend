package dat3.adventureXP.service;

import dat3.adventureXP.dto.ReservationDto;
import dat3.adventureXP.entity.Company;
import dat3.adventureXP.entity.Guest;
import dat3.adventureXP.entity.Reservation;
import dat3.adventureXP.repository.CompanyRepository;
import dat3.adventureXP.repository.GuestRepository;
import dat3.adventureXP.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final CompanyRepository companyRepository;

    public ReservationService(ReservationRepository reservationRepository, GuestRepository guestRepository, CompanyRepository companyRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.companyRepository = companyRepository;
    }

    @Transactional
    public ReservationDto createReservation(ReservationDto request) {
        // Create new reservation
        Reservation newReservation = new Reservation();
        // Set reservation details (assuming relevant fields in request DTO)
        updateReservation(newReservation, request);
        return new ReservationDto(newReservation);
    }

    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(ReservationDto::new)
                .collect(Collectors.toList());
    }

    public ReservationDto getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
        return new ReservationDto(reservation);
    }

    @Transactional
    public ReservationDto editReservation(Long id, ReservationDto request) {
        Reservation editedReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        // Update reservation details (assuming relevant fields in request DTO)
        updateReservation(editedReservation, request);
        // Save updated reservation
       reservationRepository.save(editedReservation);

        // Convert to and return ReservationDto
        return new ReservationDto(editedReservation);
    }

    private void updateReservation(Reservation reservation, ReservationDto request) {
        // set guest
        Guest guest = guestRepository.findById(request.getGuestId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest not found"));
        reservation.setReservationDate(request.getReservationDate());
        reservation.setReservationTime(request.getReservationTime());
        reservation.setNumberOfParticipants(request.getNumberOfParticipants());
        reservation.setActivities(request.getActivities());  // Set activities
        reservation.setCreated(request.getCreated());
        reservation.setEdited(request.getEdited());
    }

    public ResponseEntity<?> deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found");
        }
        reservationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
