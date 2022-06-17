package kurbanov.restapiwork.dto.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kurbanov.restapiwork.entity.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupRequestDto {
    private String groupName;
    @JsonIgnore
    private Course course;
    private Long courseId;
}
