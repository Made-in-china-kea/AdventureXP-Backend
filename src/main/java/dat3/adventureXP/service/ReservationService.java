package dat3.adventureXP.service;

import dat3.adventureXP.dto.ReservationDto;
import dat3.adventureXP.entity.*;
import dat3.adventureXP.repository.CompanyRepository;
import dat3.adventureXP.repository.GuestRepository;
import dat3.adventureXP.repository.ReservationActivityRepository;
import dat3.adventureXP.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final CompanyRepository companyRepository;
    private final ReservationActivityRepository reservationActivityRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              GuestRepository guestRepository, CompanyRepository companyRepository, ReservationActivityRepository reservationActivityRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.companyRepository = companyRepository;
        this.reservationActivityRepository = reservationActivityRepository;
    }

    @Transactional
    public ReservationDto createReservation(ReservationDto request) {
        if (request.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide the id for a new reservation");
        }
        // check if guest or company exist in repository else create new record or throw exception
        Guest existingGuest = null;
        Company existingCompany = null;
        if (request.getGuest() != null) {
            existingGuest = guestRepository.findByEmail(request.getGuest().getEmail()).orElse(null);
        } else if (request.getCompany() != null) {
            existingCompany = companyRepository.findByCompanyName(request.getCompany().getCompanyName()).orElse(null);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation must have a guest or company");
        }
        // Create new reservation
        Reservation newReservation = new Reservation();
        newReservation.setReservationDate(request.getReservationDate());

        // Save the reservation to create the ID (required for activities)
        reservationRepository.save(newReservation);
        // Set other reservation details
        newReservation.setGuest(existingGuest);
        newReservation.setCompany(existingCompany);
        newReservation.setNumberOfParticipants(request.getNumberOfParticipants());
        newReservation.setCancelled(request.isCancelled());


        // Create reservation activities with reference to the saved reservation
        for (ReservationActivity activity : request.getReservedActivities()) {
            ReservationActivity newActivity = new ReservationActivity();
            newActivity.setReservation(newReservation); // Set the saved reservation
            newActivity.setActivity(activity.getActivity());
            newActivity.setStartTime(activity.getStartTime());
            newActivity.setReservedSlots(activity.getReservedSlots());
            reservationActivityRepository.save(newActivity);
        }

        // Save updated reservation
        reservationRepository.save(newReservation);

        return new ReservationDto(newReservation);
    }

    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(ReservationDto::new)
                .collect(Collectors.toList());
    }

    public ReservationDto getReservationById(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
        return new ReservationDto(reservation);
    }

    @Transactional
    public ResponseEntity<ReservationDto> editReservation(Integer id, ReservationDto request) {
        if (!Objects.equals(request.getId(), id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing reservation");
        }
        Reservation editedReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        // Update reservation details (assuming relevant fields in request DTO)
        editedReservation.setReservationDate(request.getReservationDate());
        editedReservation.setNumberOfParticipants(request.getNumberOfParticipants());
        editedReservation.setCancelled(request.isCancelled());


        // Update reservation activities

       reservationRepository.save(editedReservation);

        // Convert to and return ReservationDto
        return ResponseEntity.ok(new ReservationDto(editedReservation));
    }

    public ResponseEntity<Reservation> deleteReservation(Integer id) {
        if (!reservationRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found");
        }
        reservationRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<ReservationDto> cancelReservation(Integer id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
        reservation.cancelReservation();
        reservationRepository.save(reservation);
        return ResponseEntity.ok(new ReservationDto(reservation));
    }
}
