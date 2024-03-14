package dat3.adventureXP.service;

import dat3.adventureXP.dto.CompanyDto;
import dat3.adventureXP.entity.Company;
import dat3.adventureXP.repository.CompanyRepository;

public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyDto createCompany(CompanyDto company) {
        Company newCompany = new Company();
        updateCompany(newCompany, company);
        companyRepository.save(newCompany);
        return new CompanyDto(newCompany);
    }

    private void updateCompany(Company company, CompanyDto companyDto) {
        company.setId(companyDto.getId());
        company.setCompanyName(companyDto.getCompanyName());
        company.setContactName(companyDto.getContactName());
        company.setContactEmail(companyDto.getContactEmail());
        company.setCvr(companyDto.getCvr());
    }
}
