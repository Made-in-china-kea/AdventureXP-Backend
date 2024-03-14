package dat3.adventureXP.service;

import dat3.adventureXP.repository.EquipmentRepository;
import dat3.adventureXP.repository.EquipmentStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentStatusRepository equipmentStatusRepository;

    public EquipmentService(EquipmentRepository equipmentRepository, EquipmentStatusRepository equipmentStatusRepository) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentStatusRepository = equipmentStatusRepository;
    }

    // Can implement methods for:
    // - Checking equipment availability for a specific reservation
    // - Updating equipment status (e.g., marking equipment as "In Use" for a reservation)


}
