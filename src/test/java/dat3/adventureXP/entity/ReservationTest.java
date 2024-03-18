package dat3.adventureXP.entity;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void addActivity() {

        //create a new reservation
        Reservation reservation = new Reservation();
        //create a new activity
        ReservationActivity activity = new ReservationActivity();
        //add the activity to the reservation
        reservation.addActivity(activity);
        //check if the activity is in the reservation
        assertTrue(reservation.getReservedActivities().contains(activity));
    }

    @Test
    void cancelReservation() {
        //create a new reservation
        Reservation reservation = new Reservation();
        //cancel the reservation
        reservation.cancelReservation();
        //check if the reservation is cancelled
        assertTrue(reservation.isCancelled());
    }

    @Test
    void getId() {
        //create a new reservation
        Reservation reservation = new Reservation();
        //set the id to 1
        reservation.setId(1);
        //check if the id is 1
        assertEquals(1, reservation.getId());
    }

    @Test
    void getGuest() {
        //create a new reservation
        Reservation reservation = new Reservation();
        //create a new guest
        Guest guest = new Guest();
        //set the guest to the reservation
        reservation.setGuest(guest);
        //check if the guest is the same as the one set
        assertEquals(guest, reservation.getGuest());
    }

    @Test
    void getCompany() {
        //create a new reservation
        Reservation reservation = new Reservation();
        //create a new company
        Company company = new Company();
        //set the company to the reservation
        reservation.setCompany(company);
        //check if the company is the same as the one set
        assertEquals(company, reservation.getCompany());

    }

    @Test
    void getReservationDate() {
        //create a new reservation
        Reservation reservation = new Reservation();
        //create a new date
        Date date = new Date();
        //set the date to the reservation
        reservation.setReservationDate(date);
        //check if the date is the same as the one set
        assertEquals(date, reservation.getReservationDate());
    }

    @Test
    void getReservationTime() {

        //create a new reservation
        Reservation reservation = new Reservation();
        //create a new time
        Time time = new Time(0);
        //set the time to the reservation
        reservation.setReservationTime(time);
        //check if the time is the same as the one set
        assertEquals(time, reservation.getReservationTime());
    }

    @Test
    void getNumberOfParticipants() {
        //create a new reservation
        Reservation reservation = new Reservation();
        //set the number of participants to 10
        reservation.setNumberOfParticipants(10);
        //check if the number of participants is 10
        assertEquals(10, reservation.getNumberOfParticipants());
    }

    @Test
    void getCreated() {


    }

    @Test
    void getEdited() {
    }

    @Test
    void isCancelled() {
    }

    @Test
    void getReservedActivities() {
    }

    @Test
    void setId() {
    }

    @Test
    void setGuest() {
    }

    @Test
    void setCompany() {
    }

    @Test
    void setReservationDate() {
    }

    @Test
    void setReservationTime() {
    }

    @Test
    void setNumberOfParticipants() {
    }

    @Test
    void setCreated() {
    }

    @Test
    void setEdited() {
    }

    @Test
    void setCancelled() {
    }

    @Test
    void setReservedActivities() {
    }
}