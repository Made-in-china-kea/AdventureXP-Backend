package dat3.adventureXP.dto;
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

     public CompanyDto(Long id, String name, String contactName, String contactEmail, Integer cvr) {
          this.id = id;
          this.name = name;
          this.contactName = contactName;
          this.contactEmail = contactEmail;
          this.cvr = cvr;
     }
}
