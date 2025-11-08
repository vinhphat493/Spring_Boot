package com.example.studentcrud.domain.repository;

import com.example.studentcrud.domain.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);

    Optional<Student> findById(Long id);

    List<Student> findAll();

    void update(Student student);

    void deleteById(Long id);

    Optional<Student> findByEmail(String email);
}