package dat3.adventureXP.repository;

import dat3.adventureXP.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    public Optional<Equipment> findByName(String name);
}
