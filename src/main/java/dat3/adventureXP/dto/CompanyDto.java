package dat3.adventureXP.dto;
import dat3.adventureXP.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDto {
        private int id;
        private String companyName;
        private String contactFirstName;
        private String contactLastName;
        private String contactEmail;
        private int cvr;

     public CompanyDto(Company c) {
         this.id = c.getId();
         this.companyName = c.getCompanyName();
         this.contactFirstName = c.getContactFirstName();
         this.contactLastName = c.getContactLastName();
         this.contactEmail = c.getContactEmail();
         this.cvr = c.getCvr();
     }
}
