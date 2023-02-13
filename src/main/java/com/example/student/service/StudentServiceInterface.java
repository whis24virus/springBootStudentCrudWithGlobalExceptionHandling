package com.example.student.service;

import com.example.student.entity.Student;

import java.util.List;

public interface StudentServiceInterface {


    //get all
    public List<Student> getAll();


    //get by id
    public Student getById(Long id);



    // post
    public Student addStudent(Student student);



    //put

    public Student updateById (Student student, Long id);



    //delete
    public void deleteById(Long id);
}
