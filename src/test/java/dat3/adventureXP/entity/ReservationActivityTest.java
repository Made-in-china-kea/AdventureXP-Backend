package dat3.adventureXP.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationActivityTest {

    @Test
    void getReservation() {

        ReservationActivity reservationActivity = new ReservationActivity();
        reservationActivity.setReservation(new Reservation());
        assertEquals(new Reservation(), reservationActivity.getReservation());
    }

    @Test
    void getActivity() {

        ReservationActivity reservationActivity = new ReservationActivity();
        Activity activity = new Activity();
        reservationActivity.setActivity(activity);
        assertEquals(activity, reservationActivity.getActivity());
    }

    @Test
    void getStartTime() {

        ReservationActivity reservationActivity = new ReservationActivity();
        reservationActivity.setStartTime(12);
        assertEquals(12, reservationActivity.getStartTime());
    }

    @Test
    void getReservedSlots() {

        ReservationActivity reservationActivity = new ReservationActivity();
        reservationActivity.setReservedSlots(10);
        assertEquals(10, reservationActivity.getReservedSlots());
    }

    @Test
    void getCreated() {

        ReservationActivity reservationActivity = new ReservationActivity();
        LocalDateTime createdDateTime = LocalDateTime.parse("2021-05-05T00:00:00");
        reservationActivity.setCreated(createdDateTime);
        assertEquals(createdDateTime, reservationActivity.getCreated());
    }
}