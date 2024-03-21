package dat3.adventureXP.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationActivityTest {

    @Test
    void getReservationId() {

        ReservationActivity reservationActivity = new ReservationActivity();
        reservationActivity.setReservationId(1);
        assertEquals(1, reservationActivity.getReservationId());
    }

    @Test
    void getActivity() {

        ReservationActivity reservationActivity = new ReservationActivity();
        Activity activity = new Activity();
        reservationActivity.setActivity(activity);
        assertEquals(activity, reservationActivity.getActivity());
    }

    @Test
    void getDate() {

        ReservationActivity reservationActivity = new ReservationActivity();
        reservationActivity.setDate("2021-05-05");
        assertEquals("2021-05-05", reservationActivity.getDate());
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