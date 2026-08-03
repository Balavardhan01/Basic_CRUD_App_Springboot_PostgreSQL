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
        student.setDeleted(false);
        return repo.save(student); // Return the entity returned by save()
    }

    public List<Student> getStudents() {
        return repo.findByDeletedIsFalse();
    }

    public Optional<Student> getStudentById(int id) {
        return Optional.ofNullable(repo.findById(id).orElse(null));
    }

    public Student updateStudent(int id, Student studentDetails) {
        // Ensure entity exists before performing update
        return repo.findByIdAndDeletedIsFalse(id).map(existingStudent -> {
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
    public boolean deleteStudentSoft(int id){
        Optional<Student> studentPresent=repo.findByIdAndDeletedIsFalse(id);
        if(studentPresent.isEmpty()) return false;

        Student save=studentPresent.get();
        save.setDeleted(true);
        repo.save(save);

        return true;
    }
}