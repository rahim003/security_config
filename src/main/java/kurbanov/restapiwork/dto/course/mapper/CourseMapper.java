package kurbanov.restapiwork.dto.course.mapper;

import kurbanov.restapiwork.dto.conver.Convert;
import kurbanov.restapiwork.dto.course.CourseRequestDto;
import kurbanov.restapiwork.dto.course.CourseResponse;
import kurbanov.restapiwork.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper implements Convert<Course, CourseRequestDto, CourseResponse> {


    @Override
    public Course convert(CourseRequestDto courseRequestDto) {
        Course course=new Course();
        course.setCourseName(courseRequestDto.getCourseName());
        course.setDuration(courseRequestDto.getDuration());
        course.setCompany(courseRequestDto.getCompany());
        return course;
    }

    @Override
    public CourseResponse deConvert(Course course) {
        CourseResponse courseResponse=new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
      //  courseResponse.setCompanyId(course.getCompany().getId());
      courseResponse.setGroup(course.getGroups());
        return courseResponse;
    }
}
