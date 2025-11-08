package com.example.studentcrud.application.dto;

// Nhận dữ liệu khi client POST
public class CreateStudentDTO {
    private String name;
    private Integer age;
    private String email;

    public CreateStudentDTO(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public CreateStudentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
