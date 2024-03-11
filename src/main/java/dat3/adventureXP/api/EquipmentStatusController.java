package dat3.adventureXP.api;

import dat3.adventureXP.repository.EquipmentStatusRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipment/status")
public class EquipmentStatusController {

    private final EquipmentStatusRepository equipmentStatusRepository;

    public EquipmentStatusController(EquipmentStatusRepository equipmentStatusRepository) {
        this.equipmentStatusRepository = equipmentStatusRepository;
    }

    // Similar CRUD operations as in ActivityController (adjust for EquipmentStatus entity)
}
