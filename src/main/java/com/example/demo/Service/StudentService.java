package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.StudentDTO;
import com.example.demo.Entity.Student;
import com.example.demo.Exception.StudentNotFoundException;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student registerStudent(StudentDTO dto) {
        Student student = new Student();

        student.setStudentName(dto.getStudentName());
        student.setCourseName(dto.getCourseName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }


    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new StudentNotFoundException(
                        "Student not found with ID: " + id
                    )
                );
    }

    public Student updateStudent(Long id, StudentDTO dto) {
        Student student = getStudentById(id);

        student.setStudentName(dto.getStudentName());
        student.setCourseName(dto.getCourseName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        return repository.save(student);
    }

 
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        repository.delete(student);
    }
}