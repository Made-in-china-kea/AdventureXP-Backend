package dat3.adventureXP.service;

import dat3.adventureXP.dto.CompanyDto;
import dat3.adventureXP.entity.Company;
import dat3.adventureXP.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyDto createCompany(CompanyDto company) {
        if (companyRepository.existsByContactEmail(company.getContactEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }
        if (companyRepository.existsByCvr(company.getCvr())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CVR already exists");
        }
        if (companyRepository.existsByCompanyName(company.getCompanyName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Company name already exists");
        }
        Company newCompany = new Company();
        updateCompany(newCompany, company);
        companyRepository.save(newCompany);
        return new CompanyDto(newCompany);
    }

    private void updateCompany(Company company, CompanyDto companyDto) {
        company.setId(companyDto.getId());
        company.setCompanyName(companyDto.getCompanyName());
        company.setContactFirstName(companyDto.getContactFirstName());
        company.setContactLastName(companyDto.getContactLastName());
        company.setContactEmail(companyDto.getContactEmail());
        company.setCvr(companyDto.getCvr());
    }
}
