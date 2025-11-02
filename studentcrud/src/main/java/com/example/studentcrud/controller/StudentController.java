package com.example.studentcrud.controller;

import com.example.studentcrud.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    //POST tạo sinh viên mới
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    //PUT cập nhật sinh viên
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student existStudent = students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
        if (existStudent != null) {
            existStudent.setName(student.getName());
            existStudent.setAge(student.getAge());
            existStudent.setEmail(student.getEmail());
            existStudent.setId(student.getId());
            return existStudent;
        }
        System.out.println("Id bạn nhập không nằm trong kho dữ liệu!!!");
        return null;
    }

    //DELETE xóa sinh viên
    @DeleteMapping("/{id}")
    public String deletedStudent(@PathVariable int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);
        return removed ? "Đã xoá sinh viên ID " + id : "Không tìm thấy sinh viên ID " + id;
    }

    //GET lấy thông tin sinh viên
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    //GET lấy danh sách sinh viên
    @GetMapping()
    public List<Student> getStudents() {
        return students;
    }
}
