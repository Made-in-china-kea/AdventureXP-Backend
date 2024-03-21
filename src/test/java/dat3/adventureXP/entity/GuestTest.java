package dat3.adventureXP.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    void getId() {
        Guest guest = new Guest();
        guest.setId(1);
        assertEquals(1, guest.getId());
    }

    @Test
    void getFirstName() {
        Guest guest = new Guest();
        guest.setFirstName("jack");
        assertEquals("jack", guest.getFirstName());
    }

    @Test
    void getLastName() {
        Guest guest = new Guest();
        guest.setLastName("jones");
        assertEquals("jones", guest.getLastName());
    }

    @Test
    void getEmail() {
        Guest guest = new Guest();
        guest.setEmail("abdu4069@stud.kea.dk");
        assertEquals("abdu4069@stud.kea.dk", guest.getEmail());
    }

    @Test
    void getCreated() {
        Guest guest = new Guest();
        assertEquals(null, guest.getCreated());
    }
}