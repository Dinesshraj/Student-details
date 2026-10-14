package com.example.demo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @NotBlank(message = "Student name cannot be empty")
    private String studentName;

    @NotBlank(message = "Course name cannot be empty")
    private String courseName;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter valid email")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be above 18")
    private Integer age;

    
}