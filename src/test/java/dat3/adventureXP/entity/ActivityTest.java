package dat3.adventureXP.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    @Test
    void getId() {

        Activity activity = new Activity();
        activity.setId(1);
        assertEquals(1, activity.getId());
    }

    @Test
    void testGetId() {

        Activity activity = new Activity();
        activity.setId(1);
        assertEquals(1, activity.getId());
    }

    @Test
    void getName() {

        Activity activity = new Activity();
        activity.setName("Test");
        assertEquals("Test", activity.getName());
    }

    @Test
    void getPrice() {

        Activity activity = new Activity();
        activity.setPrice(100);
        assertEquals(100, activity.getPrice());
    }

    @Test
    void getAgeLimit() {

        Activity activity = new Activity();
        activity.setAgeLimit(18);
        assertEquals(18, activity.getAgeLimit());
    }

    @Test
    void getTimeSlot() {

        Activity activity = new Activity();
        activity.setTimeSlot(100);
        assertEquals(100, activity.getTimeSlot());
    }
}