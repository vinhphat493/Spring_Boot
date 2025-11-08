package com.example.studentcrud.domain.service;

import com.example.studentcrud.domain.model.Student;
import com.example.studentcrud.domain.repository.StudentRepository;
import com.example.studentcrud.shared.exception.BadRequestException;

import java.util.List;
import java.util.regex.Pattern;

public class StudentService {

    private final StudentRepository studentRepository;

    //Validate email
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(String name, int age, String email) {
        // Validate email
        validateStudentData(name, age, email);

        if (studentRepository.findByEmail(email).isPresent()) {
            throw new BadRequestException("Email đã tồn tại!");
        };

        Student student = new Student(name, age, email);
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Không tìm thấy sinh viên với ID: " + id));
    }

    public Student updateStudent(Long id, String name, int age, String email) {
        // Validate email
        validateStudentData(name, age, email);

        //check is existing student
        Student existingStudent = getStudentById(id);

        if (!existingStudent.getEmail().equals(email) && studentRepository.findByEmail(email).isPresent()) {
            throw new BadRequestException("Email đã tồn tại!");
        }

        existingStudent.setName(name);
        existingStudent.setAge(age);
        existingStudent.setEmail(email);

        studentRepository.update(existingStudent);

        return existingStudent;
    }

    public void deleteStudent(Long id) {
        getStudentById(id);
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void validateStudentData(String name, Integer age, String email) {
        if (name == null || name.isEmpty()) {
            throw new BadRequestException("Tên không được bỏ trống!");
        }

        if (age == null || age < 18) {
            throw new BadRequestException("Tuổi phải lớn hơn hoặc bằng 18!");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new BadRequestException("Email không được bỏ trống!");
        }

        if (!validateEmail(email.trim())) {
            throw new BadRequestException("Email không hợp lệ!");
        }
    }

    public boolean validateEmail(String email) {
        return pattern.matcher(email).matches();
    }
}
