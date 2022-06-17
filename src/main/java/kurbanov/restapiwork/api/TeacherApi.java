package kurbanov.restapiwork.api;

import io.swagger.v3.oas.annotations.Operation;
import kurbanov.restapiwork.dto.teacher.GetTeacherDto;
import kurbanov.restapiwork.dto.teacher.TeacherRequestDto;
import kurbanov.restapiwork.dto.teacher.TeacherResponse;
import kurbanov.restapiwork.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teacher")
@AllArgsConstructor
public class TeacherApi {
    private final TeacherService teacherService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @Operation(summary = "save teacher ", description = "You can save the teacher here")
    @PostMapping("/save")
    public TeacherResponse saveTeacher(@RequestBody TeacherRequestDto teacherRequestDto) {
        return teacherService.save(teacherRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @Operation(summary = "findAll teacher ", description = "You can findAll the teacher here")
    @GetMapping
    public List<TeacherResponse> findAll() {
        return teacherService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @Operation(summary = "findById teacher ", description = "You can findById the teacher here")
    @GetMapping("/find/{id}")
    public GetTeacherDto getById(@PathVariable Long id) {
        return teacherService.findBy(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Operation(summary = "update teacher  ", description = "You can update the teacher here")
    @PatchMapping("/update/{id}")
    public TeacherResponse updateTeacher(@PathVariable Long id, @RequestBody TeacherRequestDto teacherRequestDto) {
        return teacherService.update(id, teacherRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Operation(summary = "deleteById teacher ", description = "You can delete the teacher here")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        teacherService.deleteById(id);
    }

}
