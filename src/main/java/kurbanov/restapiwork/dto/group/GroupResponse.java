package kurbanov.restapiwork.dto.group;

import kurbanov.restapiwork.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class GroupResponse {
    private Long id;
    private String groupName;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;
   // private Long courseId;
    private List<Student> student;

}
