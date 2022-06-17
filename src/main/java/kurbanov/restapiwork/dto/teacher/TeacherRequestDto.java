package kurbanov.restapiwork.dto.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kurbanov.restapiwork.entity.Course;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TeacherRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    private String email;
    private String password;
    @JsonIgnore
    private Course course;
    private Long courseId;
}
