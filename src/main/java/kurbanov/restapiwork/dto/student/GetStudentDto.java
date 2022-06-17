package kurbanov.restapiwork.dto.student;

import kurbanov.restapiwork.entity.StudyFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetStudentDto {
    private Long id;
    private String firstName;
    private String email;
    private StudyFormat studyFormat;
    private Long groupId;
}
