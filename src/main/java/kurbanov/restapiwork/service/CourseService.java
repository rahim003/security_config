package kurbanov.restapiwork.service;

import kurbanov.restapiwork.dto.course.CourseRequestDto;
import kurbanov.restapiwork.dto.course.CourseResponse;
import kurbanov.restapiwork.dto.course.GetCourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    CourseResponse save(CourseRequestDto courseRequestDto);

    List<CourseResponse> findAll();

    GetCourseDto findBy(Long id);

    CourseResponse update(Long id, CourseRequestDto courseRequestDto);

    void deleteById(Long id);

}
