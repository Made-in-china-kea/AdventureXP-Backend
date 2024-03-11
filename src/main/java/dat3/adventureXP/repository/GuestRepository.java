package dat3.adventureXP.repository;

import dat3.adventureXP.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
    public Optional<Guest> findByName(String name);
}
