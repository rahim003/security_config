package kurbanov.restapiwork.dto.teacher;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetTeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;


    private Long courseId;
}
