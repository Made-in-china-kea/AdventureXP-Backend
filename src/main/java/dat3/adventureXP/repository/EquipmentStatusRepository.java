package dat3.adventureXP.repository;

import dat3.adventureXP.entity.EquipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipmentStatusRepository extends JpaRepository<EquipmentStatus, Long> {
    public Optional<EquipmentStatus> findByName(String name);
}