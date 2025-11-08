package com.example.studentcrud.infrastructure.persistence;

import com.example.studentcrud.domain.model.Student;
import com.example.studentcrud.domain.repository.StudentRepository;
import com.example.studentcrud.shared.exception.BadRequestException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private List<Student> students = new ArrayList<>();
    private static Long nextId = 1L;


    @Override
    public Student save(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public void update(Student student) {
        Optional<Student> result = findById(student.getId());
        result.ifPresent(existing -> {
            existing.setName(student.getName());
            existing.setAge(student.getAge());
            existing.setEmail(student.getEmail());
        });
    }

    @Override
    public void deleteById(Long id) {
        students.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return students.stream()
                .filter(student -> student.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
}


