package dat3.adventureXP.api;

import dat3.adventureXP.entity.Company;
import dat3.adventureXP.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id) {
        return companyRepository.findById(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable int id) {
        companyRepository.deleteById(id);
    }
}
