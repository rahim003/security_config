package kurbanov.restapiwork.dto.course;

import kurbanov.restapiwork.entity.Group;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponse {
    private Long id;
    private String courseName;
    private String duration;
    private List<Group> group;
}
