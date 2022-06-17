package kurbanov.restapiwork.dto.group;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GetGroupDto {
    private Long id;
    private String groupName;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;
   // private Long courseId;
}
