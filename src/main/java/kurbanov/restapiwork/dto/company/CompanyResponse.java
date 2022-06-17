package kurbanov.restapiwork.dto.company;

import kurbanov.restapiwork.entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompanyResponse {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private List<Course> course;
}
