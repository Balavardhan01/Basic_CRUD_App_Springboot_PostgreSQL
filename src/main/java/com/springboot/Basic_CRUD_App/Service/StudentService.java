package com.springboot.Basic_CRUD_App.Service;

import com.springboot.Basic_CRUD_App.Entity.Student;
import com.springboot.Basic_CRUD_App.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo repo;

    public StudentService(StudentRepo repo) {
        this.repo = repo;
    }

    public Student createStudent(Student student) {
        return repo.save(student); // Return the entity returned by save()
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return repo.findById(id);
    }

    public Student updateStudent(int id, Student studentDetails) {
        // Ensure entity exists before performing update
        return repo.findById(id).map(existingStudent -> {
            existingStudent.setName(studentDetails.getName());
            existingStudent.setMail(studentDetails.getMail());
            existingStudent.setGender(studentDetails.getGender());
            existingStudent.setStream(studentDetails.getStream());
            return repo.save(existingStudent);
        }).orElse(null);
    }

    public boolean deleteStudent(int id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}