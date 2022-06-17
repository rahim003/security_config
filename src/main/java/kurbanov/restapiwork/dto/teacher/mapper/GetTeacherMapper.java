package kurbanov.restapiwork.dto.teacher.mapper;

import kurbanov.restapiwork.dto.teacher.GetTeacherDto;
import kurbanov.restapiwork.entity.Teacher;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GetTeacherMapper implements Converter<Teacher, GetTeacherDto> {
    @Override
    public GetTeacherDto convert(Teacher teacher) {
        GetTeacherDto getTeacherDto=new GetTeacherDto();
        getTeacherDto.setId(teacher.getId());
        getTeacherDto.setFirstName(teacher.getFirstName());
        getTeacherDto.setLastName(teacher.getLastName());
        getTeacherDto.setCourseId(teacher.getCourse().getId());
        return getTeacherDto;
    }
}
