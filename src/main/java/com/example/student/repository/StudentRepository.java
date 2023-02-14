package com.example.student.repository;

import com.example.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {



    //custom finder or derived query methods
    public List<Student> findByName(String name);
    public List<Student> findByNameAndAge(String name, int age);

}