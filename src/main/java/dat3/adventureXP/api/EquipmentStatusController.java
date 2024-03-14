package dat3.adventureXP.api;

import dat3.adventureXP.entity.EquipmentStatus;
import dat3.adventureXP.repository.EquipmentStatusRepository;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/equipment/status")
public class EquipmentStatusController {

    private final EquipmentStatusRepository equipmentStatusRepository;

    public EquipmentStatusController(EquipmentStatusRepository equipmentStatusRepository) {
        this.equipmentStatusRepository = equipmentStatusRepository;
    }

    // Similar CRUD operations as in ActivityController (adjust for EquipmentStatus entity)

    @GetMapping
    public List<EquipmentStatus> getAllEquipmentStatuses() {
        return equipmentStatusRepository.findAll();
    }

    @GetMapping("/{id}")

    public EquipmentStatus getEquipmentStatusById(@PathVariable Integer id) {
        return equipmentStatusRepository.findById(id).orElse(null);
    }

    @PostMapping
    public EquipmentStatus createEquipmentStatus(@RequestBody EquipmentStatus equipmentStatus) {
        return equipmentStatusRepository.save(equipmentStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEquipmentStatus(@PathVariable Integer id) {
        equipmentStatusRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}










