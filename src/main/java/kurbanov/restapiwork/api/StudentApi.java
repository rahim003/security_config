package kurbanov.restapiwork.api;

import io.swagger.v3.oas.annotations.Operation;
import kurbanov.restapiwork.dto.student.GetStudentDto;
import kurbanov.restapiwork.dto.student.StudentRequestDto;
import kurbanov.restapiwork.dto.student.StudentResponse;
import kurbanov.restapiwork.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/student")
public class StudentApi {
    private final StudentService studentService;

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @PostMapping("/save")
    @Operation(summary = "save student ", description = "You can save the student here")
    public StudentResponse saveStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.save(studentRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping()
    @Operation(summary = "findAll student ", description = "You can findAll the student here")
    public List<StudentResponse> findAll() {
        return studentService.findAll();
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PatchMapping("update/{id}")
    @Operation(summary = "update student ", description = "You can update the student here")
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) {
        return studentService.update(id, studentRequestDto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT')")
    @GetMapping("find/{id}")
    @Operation(summary = "findById student ", description = "You can findById the student here")
    public GetStudentDto getById(@PathVariable Long id) {
        return studentService.findBy(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @Operation(summary = "deleteById student ", description = "You can delete the student here")
    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
