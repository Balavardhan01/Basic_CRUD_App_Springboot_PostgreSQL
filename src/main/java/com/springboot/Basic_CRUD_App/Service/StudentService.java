package com.springboot.Basic_CRUD_App.Service;

import com.springboot.Basic_CRUD_App.Entity.Student;
import com.springboot.Basic_CRUD_App.Repository.StudentRepo;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepo repo;
    public StudentService(StudentRepo repo){
        this.repo=repo;
    }

    public Student createStudent(Student student){
        repo.save(student);
        return student;
    }
}
