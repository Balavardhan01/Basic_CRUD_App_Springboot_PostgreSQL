package com.springboot.Basic_CRUD_App.Controller;


import com.springboot.Basic_CRUD_App.Entity.Student;
import com.springboot.Basic_CRUD_App.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService service;
    public StudentController(StudentService service){
        this.service=service;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent=service.createStudent(student);
        return  ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getStudentById(id));
    }
}
