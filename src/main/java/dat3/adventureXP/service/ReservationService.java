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
    private final GuestService guestService;
    private final CompanyService companyService;

    public ReservationService(ReservationRepository reservationRepository,
                              GuestRepository guestRepository, CompanyRepository companyRepository,
                              ReservationActivityRepository reservationActivityRepository,
                              GuestService guestService, CompanyService companyService) {
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
        this.companyRepository = companyRepository;
        this.reservationActivityRepository = reservationActivityRepository;
        this.guestService = guestService;
        this.companyService = companyService;
    }

    @Transactional
    public ReservationDto createReservation(ReservationDto request) {
        if (request.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide the id for a new reservation");
        }
        // Create new reservation
        Reservation newReservation = new Reservation();
        newReservation.setReservationDate(request.getReservationDate());

        // Save the reservation to create the ID (required for activities)
        reservationRepository.save(newReservation);

        // check if guest or company exist in repository else create new record and set in the reservation
        if (request.getGuest() != null) {
            newReservation.setCompany(null);
            Guest existingGuest = guestRepository.findByEmail(request.getGuest().getEmail()).orElse(null);
            if (existingGuest == null) {
                Guest newGuest = guestService.createGuest(request.getGuest());
                newReservation.setGuest(newGuest);
                System.out.println("newGuest: " + newGuest);
            }  else {
                newReservation.setGuest(existingGuest);
                System.out.println("Guest have been here before. Welcome again " + existingGuest.getFirstName() + " " + existingGuest.getLastName());
            }

        } else if (request.getCompany() != null) {
            newReservation.setGuest(null);
            Company existingCompany = companyRepository.findByCompanyName(request.getCompany().getCompanyName()).orElse(null);
            if (existingCompany == null) {
                Company newCompany = companyService.createCompany(request.getCompany());
                newReservation.setCompany(newCompany);
                System.out.println("newCompany: " + newCompany);
            } else {
                newReservation.setCompany(existingCompany);
                System.out.println("Company have been here before. Welcome again " + existingCompany.getCompanyName());
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Reservation must have a guest or company");
        }

        // Set other reservation details
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
