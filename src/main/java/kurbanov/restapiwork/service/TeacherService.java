package kurbanov.restapiwork.service;

import kurbanov.restapiwork.dto.teacher.GetTeacherDto;
import kurbanov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanov.restapiwork.dto.teacher.TeacherResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    TeacherResponse save(TeacherRequestDto teacherRequestDto);

    List<TeacherResponse> findAll();

    GetTeacherDto findBy(Long id);

    TeacherResponse update(Long id, TeacherRequestDto teacherRequestDto);

    void deleteById(Long id);

    TeacherResponse getById(Long id);
}
