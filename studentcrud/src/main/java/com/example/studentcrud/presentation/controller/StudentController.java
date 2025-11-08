package com.example.studentcrud.presentation.controller;

import com.example.studentcrud.application.dto.CreateStudentDTO;
import com.example.studentcrud.application.dto.StudentDTO;
import com.example.studentcrud.application.dto.UpdateStudentDTO;
import com.example.studentcrud.domain.model.Student;
import com.example.studentcrud.domain.service.StudentService;
import com.example.studentcrud.shared.response.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public StudentDTO mapToDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getAge(),
                student.getEmail()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentDTO>> createStudent(@Valid @RequestBody CreateStudentDTO request) {
        Student newStudent = studentService.createStudent(request.getName(), request.getAge(), request.getEmail());
        StudentDTO studentDTO = mapToDTO(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(studentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDTO>> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getAge(), student.getEmail());
        return ResponseEntity.ok(ApiResponse.ok(studentDTO));
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<StudentDTO>>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        List<StudentDTO> studentDTOs = students.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ApiResponse.ok(studentDTOs));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentDTO>> updateStudent(@PathVariable Long id, @Valid @RequestBody UpdateStudentDTO request) {
        Student updatedStudent = studentService.updateStudent(id, request.getName(), request.getAge(), request.getEmail());
        return ResponseEntity.ok(ApiResponse.updated(mapToDTO(updatedStudent)));
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok(ApiResponse.deleted());
    }
}
