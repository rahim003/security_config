package kurbanov.restapiwork.dto.company;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequestDto {
    private String companyName;
    private String locatedCountry;
}
