package com.springboot.Basic_CRUD_App.Controller;

import com.springboot.Basic_CRUD_App.Entity.Student;
import com.springboot.Basic_CRUD_App.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student.setDeleted(false);
        Student createdStudent = service.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @GetMapping("/fetch")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(service.getStudents()); // Returns 200 OK
    }

    @GetMapping("/fetchById")
    public ResponseEntity<Student> getStudentById(@RequestParam int id) {
        return service.getStudentById(id)
                .map(ResponseEntity::ok) // Unwraps Optional and returns 200 OK with Student
                .orElseGet(() -> ResponseEntity.notFound().build()); // Returns 404 NOT FOUND
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam int id, @RequestBody Student student) {
        Student updatedStudent = service.updateStudent(id, student);
        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam int id) {
        boolean isDeleted = service.deleteStudent(id);
        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Student deleted permanently with ID: " + id);
    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> softDelete(@RequestParam int id){
        Boolean isDeleted=service.deleteStudentSoft(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Student Deleted");
    }
}