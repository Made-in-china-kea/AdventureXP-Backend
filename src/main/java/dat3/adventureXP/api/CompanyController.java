package dat3.adventureXP.api;

import dat3.adventureXP.entity.Company;
import dat3.adventureXP.repository.CompanyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Similar CRUD operations as in ActivityController (adjust for Company entity)


    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }



    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Integer id) {
        return companyRepository.findById(id).orElse(null);
    }
    

}
