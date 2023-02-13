package com.example.student.service;


import com.example.student.entity.Student;
import com.example.student.exception.EmptyInputException;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepository repository;


    // get all
    @Override
    public List<Student> getAll(){
        return repository.findAll();

    }


    //get by id
    @Override
    public Student getById(Long id){
        return repository.findById(id).get();
    }


    // post
    @Override
    public Student addStudent(Student student){
        //exception handling
        //currently no need validation already in place
//        if(student.getName().isEmpty() || student.getName().length() == 0){
//            throw new EmptyInputException("601", "Input fields are empty");
//        }


        Student savedStudent = repository.save(student);
        return savedStudent;
    }



//    //put
//
   public Student updateById (Student student, Long id){
       Student checkStudent = repository.findById(id).get();
       checkStudent.setName(student.getName());
       checkStudent.setAge(student.getAge());;
       checkStudent.setHobby(student.getHobby());
       Student updatedStudent = repository.save(checkStudent);
       return updatedStudent;

    }



    //delete
    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
