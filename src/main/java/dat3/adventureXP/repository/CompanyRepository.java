package dat3.adventureXP.repository;

import dat3.adventureXP.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    public Optional<Company> findByName(String name);
}
