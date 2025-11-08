package com.example.studentcrud.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

// Nhận dữ liệu khi client PUT
@Validated
public class UpdateStudentDTO {
    @NotBlank(message = "Tên không được bỏ trống")
    private String name;

    @Min(value = 18, message = "Tuổi phải >= 18")
    private Integer age;

    @Email(message = "Email phải đúng định dạng")
    private String email;

    public UpdateStudentDTO(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public UpdateStudentDTO() {
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
