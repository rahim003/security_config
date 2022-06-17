package kurbanov.restapiwork.service.impl;

import kurbanov.restapiwork.dto.student.GetStudentDto;
import kurbanov.restapiwork.dto.student.StudentRequestDto;
import kurbanov.restapiwork.dto.student.StudentResponse;
import kurbanov.restapiwork.dto.student.mapper.GetStudentMapper;
import kurbanov.restapiwork.dto.student.mapper.StudentMapper;
import kurbanov.restapiwork.entity.Student;
import kurbanov.restapiwork.entity.StudyFormat;
import kurbanov.restapiwork.exception.BadRequestException;
import kurbanov.restapiwork.exception.NotFoundException;
import kurbanov.restapiwork.repository.GroupRepository;
import kurbanov.restapiwork.repository.StudentRepository;
import kurbanov.restapiwork.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GetStudentMapper getStudentMapper;
    private final GroupRepository groupRepository;

    @Override
    public StudentResponse save(StudentRequestDto studentRequestDto) {
        String email = studentRequestDto.getEmail();
        boolean exists = studentRepository.existsByEmail(email);
        if (exists) {
            throw new BadRequestException(
                    String.format("student with email = %s has already exists", email)
            );
        }
        studentRequestDto.setGroup(groupRepository.getById(studentRequestDto.getGroupId()));
        Student student = studentMapper.convert(studentRequestDto);
        Student save = studentRepository.save(student);
        return studentMapper.deConvert(save);
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::deConvert).toList();
    }

    @Override
    public GetStudentDto findBy(Long id) {
        if (id != null) {
            Student student = findById(id);
            return getStudentMapper.convert(student);
        } else {
            throw new NotFoundException(
                    String.format("not found=%s id", id)
            );
        }
    }

    private Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        String.format("student with id = %s does not exists", id)
                ));
    }

    @Override
    @Transactional
    public StudentResponse update(Long id, StudentRequestDto studentRequestDto) {
        Student student = findById(id);
        String currents = student.getFirstName();
        String newFirstName = studentRequestDto.getFirstName();
        if (!currents.equals(newFirstName)) {
            student.setFirstName(newFirstName);
        }
        String currentEmail = student.getUser().getEmail();
        String newEmail = studentRequestDto.getEmail();
        if (!currentEmail.equals(newEmail)) {
            student.getUser().setEmail(newEmail);
        }
        StudyFormat concurrent = student.getStudyFormat();
        StudyFormat format = studentRequestDto.getStudyFormat();
        if (!concurrent.equals(format)) {
            student.setStudyFormat(format);
        }

        return studentMapper.deConvert(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}
