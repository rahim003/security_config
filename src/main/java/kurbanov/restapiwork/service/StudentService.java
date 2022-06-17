package kurbanov.restapiwork.service;

import kurbanov.restapiwork.dto.student.GetStudentDto;
import kurbanov.restapiwork.dto.student.StudentRequestDto;
import kurbanov.restapiwork.dto.student.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    StudentResponse save(StudentRequestDto studentRequestDto);

    List<StudentResponse> findAll();

    GetStudentDto findBy(Long id);

    StudentResponse update(Long id, StudentRequestDto studentRequestDto);

    void deleteById(Long id);


}
