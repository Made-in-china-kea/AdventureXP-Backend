package dat3.adventureXP.entity;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void addActivity() {

        Reservation reservation = new Reservation();
        ReservationActivity activity = new ReservationActivity();
        reservation.addActivity(activity);
        assertTrue(reservation.getReservedActivities().contains(activity));
    }

    @Test
    void cancelReservation() {

        Reservation reservation = new Reservation();
        reservation.cancelReservation();
        assertTrue(reservation.isCancelled());
    }

    @Test
    void getId() {

        Reservation reservation = new Reservation();
        reservation.setId(1);
        assertEquals(1, reservation.getId());
    }

    @Test
    void getGuest() {

        Reservation reservation = new Reservation();
        Guest guest = new Guest();
        reservation.setGuest(guest);
        assertEquals(guest, reservation.getGuest());
    }

    @Test
    void getCompany() {

        Reservation reservation = new Reservation();
        Company company = new Company();
        reservation.setCompany(company);
        assertEquals(company, reservation.getCompany());

    }

    @Test
    void getReservationDate() {

        Reservation reservation = new Reservation();
        Date date = new Date();
        reservation.setReservationDate(date);
        assertEquals(date, reservation.getReservationDate());
    }

    @Test
    void getReservationTime() {

        Reservation reservation = new Reservation();
        Time time = new Time(0);
        reservation.setReservationTime(time);
        assertEquals(time, reservation.getReservationTime());
    }

    @Test
    void getNumberOfParticipants() {

        Reservation reservation = new Reservation();
        reservation.setNumberOfParticipants(10);
        assertEquals(10, reservation.getNumberOfParticipants());
    }

    @Test
    void getCreated() {

        Reservation reservation = new Reservation();
        LocalDateTime date = LocalDateTime.now();
        reservation.setCreated(date);
        assertEquals(date, reservation.getCreated());

    }

    @Test
    void getEdited() {

        Reservation reservation = new Reservation();
        LocalDateTime date = LocalDateTime.now();
        reservation.setEdited(date);
        assertEquals(date, reservation.getEdited());


    }

    @Test
    void isCancelled() {

        Reservation reservation = new Reservation();
        reservation.cancelReservation();
        assertTrue(reservation.isCancelled());
    }

    @Test
    void getReservedActivities() {

        Reservation reservation = new Reservation();
        ReservationActivity activity = new ReservationActivity();
        reservation.addActivity(activity);
        assertTrue(reservation.getReservedActivities().contains(activity));
    }
}
