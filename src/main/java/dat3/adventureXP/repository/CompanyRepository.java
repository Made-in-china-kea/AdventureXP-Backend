package dat3.adventureXP.repository;

import dat3.adventureXP.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    public Optional<Company> findByCompanyName(String companyName);

    public boolean existsByContactEmail(String contactEmail);
    public boolean existsByCvr(Integer cvr);
    public boolean existsByCompanyName(String companyName);
}
