package dat3.adventureXP.service;

import dat3.adventureXP.dto.CompanyDto;
import dat3.adventureXP.dto.GuestDto;
import dat3.adventureXP.dto.ReservationDto;
import dat3.adventureXP.entity.Company;
import dat3.adventureXP.entity.Guest;
import dat3.adventureXP.entity.Reservation;
import dat3.adventureXP.entity.ReservationActivity;
import dat3.adventureXP.repository.CompanyRepository;
import dat3.adventureXP.repository.GuestRepository;
import dat3.adventureXP.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;
    private final CompanyRepository companyRepository;

    private final GuestService guestService;

    private final CompanyService companyService;

    public ReservationService(ReservationRepository reservationRepository, GuestRepository guestRepository, CompanyRepository companyRepository) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.companyRepository = companyRepository;
        this.guestService = new GuestService(guestRepository);
        this.companyService = new CompanyService(companyRepository);
    }

    @Transactional
    public ReservationDto createReservation(ReservationDto request) {
        if (request.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide the id for a new reservation");
        }
        // check if guest or company exist in repository else create new record
        if (request.getGuest() != null) {
            if (guestRepository.findByEmail(request.getGuest().getEmail()).isEmpty()) {
                GuestDto newGuest = guestService.createGuest(request.getGuest());
                System.out.println("newGuest: " + newGuest);
            }  else {
                System.out.println("Guest have been here before. Welcome again " + request.getGuest().getEmail() );
                }

        } else if (request.getCompany() != null) {
            if (companyRepository.findByCompanyName(request.getCompany().getCompanyName()).isEmpty()) {
                CompanyDto newCompany = companyService.createCompany(request.getCompany());
                System.out.println("newCompany: " + newCompany);
            } else {
                System.out.println("Company have been here before. Welcome again " + request.getCompany().getCompanyName() );
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation must have a guest or company");
        }

        // Create new reservation
        Reservation newReservation = new Reservation();
        // Set reservation details
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
    public ResponseEntity<ReservationDto> editReservation(Long id, ReservationDto request) {
        if (!Objects.equals(request.getId(), id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing reservation");
        }
        Reservation editedReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        // Update reservation details (assuming relevant fields in request DTO)
        updateReservation(editedReservation, request);
        // Save updated reservation
       reservationRepository.save(editedReservation);

        // Convert to and return ReservationDto
        return ResponseEntity.ok(new ReservationDto(editedReservation));
    }

    private void updateReservation(Reservation reservation, ReservationDto request) {
        // set guest or company
        reservation.setGuest(new Guest(request.getGuest()));
        reservation.setCompany(new Company(request.getCompany()));
        reservation.setReservationDate(request.getReservationDate());
        reservation.setReservationTime(request.getReservationTime());
        reservation.setNumberOfParticipants(request.getNumberOfParticipants());
        reservation.setActivities(request.getActivities());  // Set activities
        reservation.setCreated(request.getCreated());
        reservation.setEdited(request.getEdited());
    }

    public ResponseEntity<Reservation> deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found");
        }
        reservationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    public Set<ReservationActivity> getReservationActivities(Long reservationId) {
        // Find the reservation by id
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        // Get the activities associated with the reservation
        Set<ReservationActivity> activities = reservation.getActivities();

        return activities;
    }
}
