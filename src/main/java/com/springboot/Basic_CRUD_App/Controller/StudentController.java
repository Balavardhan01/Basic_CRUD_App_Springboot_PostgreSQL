package com.springboot.Basic_CRUD_App.Controller;


import com.springboot.Basic_CRUD_App.Entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService service;
    public StudentController(StudentService service){
        this.service=service;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(Student student){
        Student createdStudent=service.createStudent(student);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
}
