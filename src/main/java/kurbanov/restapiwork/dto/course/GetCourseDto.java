package kurbanov.restapiwork.dto.course;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCourseDto {
    private Long id;
    private String courseName;
    private String duration;
    private Long companyId;
}
