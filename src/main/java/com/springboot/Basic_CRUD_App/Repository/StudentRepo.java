package com.springboot.Basic_CRUD_App.Repository;

import com.springboot.Basic_CRUD_App.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {


}
