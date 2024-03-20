package dat3.adventureXP.api;

import dat3.adventureXP.entity.Equipment;
import dat3.adventureXP.repository.EquipmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentRepository equipmentRepository;

    public EquipmentController(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    // Similar CRUD operations as in ActivityController (adjust for Equipment entity)


    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }


    @GetMapping("/{id}")
    public Equipment getEquipmentById(@PathVariable Integer id) {
        return equipmentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment not found"));
    }


    @PostMapping
    public Equipment createEquipment(@RequestBody Equipment equipment) {
        return equipmentRepository.save(equipment);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Equipment> deleteEquipment(@PathVariable Integer id) {
        if (!equipmentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Equipment not found");
        }
        equipmentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}