package kurbanov.restapiwork.service.impl;

import kurbanov.restapiwork.dto.course.CourseRequestDto;
import kurbanov.restapiwork.dto.course.CourseResponse;
import kurbanov.restapiwork.dto.course.GetCourseDto;
import kurbanov.restapiwork.dto.course.mapper.CourseMapper;
import kurbanov.restapiwork.dto.course.mapper.GetCourseMapper;
import kurbanov.restapiwork.entity.Course;
import kurbanov.restapiwork.exception.NotFoundException;
import kurbanov.restapiwork.repository.CompanyRepository;
import kurbanov.restapiwork.repository.CourseRepository;
import kurbanov.restapiwork.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepository;
    private final CourseMapper courseMapper;
    private final GetCourseMapper getCourseMapper;

    @Override
    public CourseResponse save(CourseRequestDto courseRequestDto) {
        courseRequestDto.setCompany(companyRepository.getById(courseRequestDto.getCompanyId()));
        Course course = courseMapper.convert(courseRequestDto);
        Course save = courseRepository.save(course);
        log.info("successful save course:{}", course);
        return courseMapper.deConvert(save);

    }

    @Override
    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream()
                .map(courseMapper::deConvert).toList();
    }

    @Override
    public GetCourseDto findBy(Long id) {
        if (id != null) {
            Course course = findById(id);
            log.info("successful find by id:{}", id);
            return getCourseMapper.convert(course);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)
            );
        }
    }

    private Course findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("course with id = %s does not exists", id)
                ));
    }


    @Override
    @Transactional
    public CourseResponse update(Long id, CourseRequestDto courseRequestDto) {
        Course course = findById(id);
        String currentCourseName = course.getCourseName();
        String newCourseName = courseRequestDto.getCourseName();
        if (!currentCourseName.equals(newCourseName)) {
            course.setCourseName(newCourseName);
        }
        String currenDuration = course.getDuration();
        String newDuration = courseRequestDto.getDuration();
        if (!currenDuration.equals(newDuration)) {
            course.setDuration(newDuration);
        }
        log.info("successful update course id:{}", id);
        return courseMapper.deConvert(course);
    }

    @Override
    public void deleteById(Long id) {
        log.info("successful delete by id course:{}", id);
        courseRepository.deleteById(id);

    }

}
