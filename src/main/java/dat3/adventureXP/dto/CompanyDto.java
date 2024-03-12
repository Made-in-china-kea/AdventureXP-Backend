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
     private Long id;
     private String name;
     private String contactName;
     private String contactEmail;
     private Integer cvr;

     public CompanyDto(Company c) {
         this.id = c.getId();
         this.name = c.getName();
         this.contactName = c.getContactName();
         this.contactEmail = c.getContactEmail();
         this.cvr = c.getCvr();
     }
}
