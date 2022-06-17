package kurbanov.restapiwork.api;

import io.swagger.v3.oas.annotations.Operation;
import kurbanov.restapiwork.dto.course.CourseRequestDto;
import kurbanov.restapiwork.dto.course.CourseResponse;
import kurbanov.restapiwork.dto.course.GetCourseDto;
import kurbanov.restapiwork.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/course")
public class CourseApi {
    private final CourseService courseService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    @Operation(summary = "save course ", description = "You can save the course here")
    public CourseResponse saveCourse(@RequestBody CourseRequestDto courseRequestDto) {
        return courseService.save(courseRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping
    @Operation(summary = "findAll course ", description = "You can findAll the course here")

    public List<CourseResponse> findAllCourse() {
        return courseService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping("find/{id}")
    @Operation(summary = "findById course ", description = "You can findById the course here")

    public GetCourseDto findByIdCourse(@PathVariable Long id) {
        return courseService.findBy(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("update/{id}")
    @Operation(summary = "update course", description = "You can update the course here")

    public CourseResponse update(@PathVariable Long id, @RequestBody CourseRequestDto courseRequestDto) {
        return courseService.update(id, courseRequestDto);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("delete/{id}")
    public void deleteByIdCourse(@PathVariable Long id) {

        courseService.deleteById(id);
    }
}
