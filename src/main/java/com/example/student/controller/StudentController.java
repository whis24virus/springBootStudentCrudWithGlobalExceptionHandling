package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import com.example.student.service.StudentServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentServiceInterface studentService;



    // get list of all users
    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> listOfStudents = studentService.getAll();
        return new ResponseEntity<List<Student>>(listOfStudents, HttpStatus.OK);
    }

    //get a user by id
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        Student studentRetrieved = studentService.getById(id);
        return new ResponseEntity<Student>(studentRetrieved, HttpStatus.OK);
    }



    //create a new user or create data
    @PostMapping("/save")
    public ResponseEntity<Student> save(@Valid @RequestBody Student student) {
        Student studentSaved = studentService.addStudent(student);
        return new ResponseEntity<Student>(studentSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody Student student) {

        Student updatedStudent;
        updatedStudent = studentService.updateById(student, id);
        return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}

