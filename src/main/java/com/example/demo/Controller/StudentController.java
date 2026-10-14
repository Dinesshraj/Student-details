package com.example.demo.Controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Dto.StudentDTO;
import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
@Validated
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/studentsRegistration")
    @ResponseStatus(HttpStatus.CREATED)
    public Student registerStudent(
            @Valid @RequestBody StudentDTO dto) {

        return service.registerStudent(dto);
    }

    @GetMapping("/displayall")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

 
    @GetMapping("/display/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

   
    @PutMapping("/update/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDTO dto) {

        return service.updateStudent(id, dto);
    }
}