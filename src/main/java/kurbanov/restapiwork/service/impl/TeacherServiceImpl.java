package kurbanov.restapiwork.service.impl;

import kurbanov.restapiwork.dto.teacher.GetTeacherDto;
import kurbanov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanov.restapiwork.dto.teacher.TeacherResponse;
import kurbanov.restapiwork.dto.teacher.mapper.GetTeacherMapper;
import kurbanov.restapiwork.dto.teacher.mapper.TeacherMapper;
import kurbanov.restapiwork.entity.Teacher;
import kurbanov.restapiwork.exception.BadRequestException;
import kurbanov.restapiwork.exception.NotFoundException;
import kurbanov.restapiwork.repository.CourseRepository;
import kurbanov.restapiwork.repository.TeacherRepository;
import kurbanov.restapiwork.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final GetTeacherMapper getTeacherMapper;
    private final CourseRepository courseRepository;

    @Override
    public TeacherResponse save(TeacherRequestDto teacherRequestDto) {
            teacherRequestDto.setCourse(courseRepository.getById(teacherRequestDto.getCourseId()));
            Teacher teacher = teacherMapper.convert(teacherRequestDto);
            Teacher save = teacherRepository.save(teacher);
            return teacherMapper.deConvert(save);
    }

    @Override
    public List<TeacherResponse> findAll() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::deConvert).toList();
    }

    @Override
    public GetTeacherDto findBy(Long id) {
        if (id != null) {
            Teacher teacher = findById(id);
            return getTeacherMapper.convert(teacher);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)

            );
        }
    }

    private Teacher findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("teacher with id = %s does not exists", id)
                ));
    }
    @Override
    @Transactional
    public TeacherResponse update(Long id, TeacherRequestDto teacherRequestDto) {
        Teacher teacher = findById(id);
        String currentFirstName = teacher.getFirstName();
        String newFirstName = teacherRequestDto.getFirstName();
        if (!currentFirstName.equals(newFirstName)) {
            teacher.setFirstName(newFirstName);
        }
        String currentLastName = teacher.getLastName();
        String newLastName = teacherRequestDto.getLastName();
        if (!currentLastName.equals(newLastName)) {
            teacher.setLastName(newLastName);
        }
        return teacherMapper.deConvert(teacher);
    }
    @Override
    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherResponse getById(Long id) {
        return teacherMapper.deConvert(teacherRepository.getById(id));

    }
}
