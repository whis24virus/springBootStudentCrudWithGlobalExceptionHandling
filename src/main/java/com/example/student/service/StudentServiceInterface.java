package com.example.student.service;

import com.example.student.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentServiceInterface {


    //get all
    public List<Student> getAll();


    //get all sorted by field

    public List<Student> getStudentsWithSorting(String field);

    //get all by pageination
    public Page<Student> getStudentsWithPagination(int offset, int pageSize);


    //get all by pagination and sorting
    public Page<Student> getStudentsWithPaginationAndSorting(int pageSize, int offset, String field);

    //get by id
    public Student getById(Long id);

    //get by name
    public List<Student> getByName(String name);

    //get by name and age

    public List<Student> getByNameAndAge(String name, int age);



    // post
    public Student addStudent(Student student);



    //put

    public Student updateById (Student student, Long id);



    //delete
    public void deleteById(Long id);
}
