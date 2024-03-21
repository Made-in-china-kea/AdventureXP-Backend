package dat3.adventureXP.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentTest {

    @Test
    void getId() {

        Equipment equipment = new Equipment();
        equipment.setId(1);
        assertEquals(1, equipment.getId());
    }

    @Test
    void getName() {

        Equipment equipment = new Equipment();
        equipment.setName("Abed");
        assertEquals("Abed", equipment.getName());
    }

    @Test
    void getActivity() {

        Equipment equipment = new Equipment();
        Activity activity = new Activity();
        equipment.setActivity(activity);
        assertEquals(activity, equipment.getActivity());
    }
}