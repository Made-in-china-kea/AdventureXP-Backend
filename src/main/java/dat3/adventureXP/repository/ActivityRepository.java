package dat3.adventureXP.repository;

import dat3.adventureXP.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    public Optional<Activity> findByName(String name);
}
