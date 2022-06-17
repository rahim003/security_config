package kurbanov.restapiwork.dto.student.mapper;

import kurbanov.restapiwork.dto.conver.Convert;
import kurbanov.restapiwork.dto.student.StudentRequestDto;
import kurbanov.restapiwork.dto.student.StudentResponse;
import kurbanov.restapiwork.entity.Role;
import kurbanov.restapiwork.entity.Student;
import kurbanov.restapiwork.entity.User;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements Convert<Student, StudentRequestDto, StudentResponse> {
    @Override
    public Student convert(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setFirstName(studentRequestDto.getFirstName());
        student.setStudyFormat(studentRequestDto.getStudyFormat());
        student.setGroup(studentRequestDto.getGroup());
        User user=new User();
        user.setEmail(studentRequestDto.getEmail());
        user.setPassword(studentRequestDto.getPassword());
        user.setRole(Role.STUDENT);
        student.setUser(user);
        return student;
    }

    @Override
    public StudentResponse deConvert(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setId(student.getId());
        studentResponse.setStudyFormat(student.getStudyFormat());
        studentResponse.setGroupId(student.getGroup().getId());
        return studentResponse;
    }
}
