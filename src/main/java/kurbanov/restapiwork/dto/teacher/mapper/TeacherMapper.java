package kurbanov.restapiwork.dto.teacher.mapper;

import kurbanov.restapiwork.dto.conver.Convert;
import kurbanov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanov.restapiwork.dto.teacher.TeacherResponse;
import kurbanov.restapiwork.entity.Role;
import kurbanov.restapiwork.entity.Teacher;
import kurbanov.restapiwork.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper implements Convert<Teacher, TeacherRequestDto, TeacherResponse> {

    @Override
    public Teacher convert(TeacherRequestDto teacherRequestDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequestDto.getFirstName());
        teacher.setLastName(teacherRequestDto.getLastName());
        teacher.setCourse(teacherRequestDto.getCourse());
        User user = new User();
        user.setEmail(teacherRequestDto.getEmail());
        user.setPassword(teacherRequestDto.getPassword());
        user.setRole(Role.TEACHER);
        teacher.setUser(user);
        return teacher;
    }

    @Override
    public TeacherResponse deConvert(Teacher teacher) {
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacher.getId());
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setCourseId(teacher.getCourse().getId());
        return teacherResponse;
    }
}
