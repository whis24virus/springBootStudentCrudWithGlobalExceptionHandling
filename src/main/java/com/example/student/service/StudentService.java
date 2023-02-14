package com.example.student.service;


import com.example.student.entity.Student;
import com.example.student.exception.EmptyInputException;
import com.example.student.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepository repository;


    //initial process for data for in mem database pagination and sorting demo
    @PostConstruct
    public void initDB(){
        List<Student> students = IntStream.rangeClosed(1, 200)
                        .mapToObj(i -> {
                            return new Student("name" + i, "hobby" + new Random().nextInt(100), new Random().nextInt(50) + 1);
                        })
                                .collect(Collectors.toList());
        repository.saveAll(students);
    }


    // get all
    @Override
    public List<Student> getAll(){
        return repository.findAll();

    }


    //get list of students after sorting
    public List<Student> getStudentsWithSorting(String field){
        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }


    //get list of students - pagination example
    public Page<Student> getStudentsWithPagination(int pageSize, int offset){
        Page<Student> studentsPage = repository.findAll(PageRequest.of(offset, pageSize));
        return studentsPage;

    }

    //get list of students with pagination and sorting
    public Page<Student> getStudentsWithPaginationAndSorting(int pageSize, int offset, String field){
        Page<Student> studentsPage = repository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.Direction.ASC, field));
        return studentsPage;

    }


    //get by id
    @Override
    public Student getById(Long id){
        return repository.findById(id).get();
    }

    // get by name custom

    @Override
    public List<Student> getByName(String name){
        return repository.findByName(name);
    }



    @Override
    public List<Student> getByNameAndAge(String name, int age){
        return repository.findByNameAndAge(name, age);
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
