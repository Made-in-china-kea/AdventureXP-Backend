package dat3.adventureXP.dto;
import dat3.adventureXP.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDto {
     private Integer id;
     private String companyName;
     private String contactName;
     private String contactEmail;
     private Integer cvr;

     public CompanyDto(Company c) {
         this.id = c.getId();
         this.companyName = c.getCompanyName();
         this.contactName = c.getContactName();
         this.contactEmail = c.getContactEmail();
         this.cvr = c.getCvr();
     }
}
