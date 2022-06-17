package kurbanov.restapiwork.dto.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kurbanov.restapiwork.entity.Group;
import kurbanov.restapiwork.entity.StudyFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class StudentRequestDto {
    private String firstName;
    private String email;
    @JsonIgnore
    private Group group;
    private String password;
    private Long groupId;
    private StudyFormat studyFormat;
}
