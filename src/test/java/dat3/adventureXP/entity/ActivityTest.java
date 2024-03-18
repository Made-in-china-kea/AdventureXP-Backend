package dat3.adventureXP.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    @Test
    void getId() {
        //create a new activity
        Activity activity = new Activity();
        //set the id to 1
        activity.setId(1);
        //check if the id is 1
        assertEquals(1, activity.getId());
    }

    @Test
    void testGetId() {

        //create a new activity
        Activity activity = new Activity();
        //set the id to 1
        activity.setId(1);
        //check if the id is 1
        assertEquals(1, activity.getId());
    }

    @Test
    void getName() {

        //create a new activity
        Activity activity = new Activity();
        //set the name to "Test"
        activity.setName("Test");
        //check if the name is "Test"
        assertEquals("Test", activity.getName());
    }

    @Test
    void getPrice() {
        //create a new activity
        Activity activity = new Activity();
        //set the price to 100
        activity.setPrice(100);
        //check if the price is 100
        assertEquals(100, activity.getPrice());
    }

    @Test
    void getAgeLimit() {
        //create a new activity
        Activity activity = new Activity();
        //set the age limit to 18
        activity.setAgeLimit(18);
        //check if the age limit is 18
        assertEquals(18, activity.getAgeLimit());
    }

    @Test
    void getTimeSlot() {
        //create a new activity
        Activity activity = new Activity();
        //set the time slot to 100
        activity.setTimeSlot(100);
        //check if the time slot is 100
        assertEquals(100, activity.getTimeSlot());
    }

    @Test
    void setId() {
        //create a new activity
        Activity activity = new Activity();
        //set the id to 1
        activity.setId(3);
        //check if the id is 1
        assertEquals(3, activity.getId());
    }

    @Test
    void setName() {
        //create a new activity
        Activity activity = new Activity();
        //set the name to "Test"
        activity.setName("Test");
        //check if the name is "Test"
        assertEquals("Test", activity.getName());
    }

    @Test
    void setPrice() {
        //create a new activity
        Activity activity = new Activity();
        //set the price to 100
        activity.setPrice(100);
        //check if the price is 100
        assertEquals(100, activity.getPrice());
    }

    @Test
    void setAgeLimit() {
        //create a new activity
        Activity activity = new Activity();
        //set the age limit to 18
        activity.setAgeLimit(18);
        //check if the age limit is 18
        assertEquals(18, activity.getAgeLimit());
    }

    @Test
    void setTimeSlot() {
        //create a new activity
        Activity activity = new Activity();
        //set the time slot to 100
        activity.setTimeSlot(100);
        //check if the time slot is 100
        assertEquals(100, activity.getTimeSlot());
    }
}