package com.example.SpringBootRestApi.controller;


import com.example.SpringBootRestApi.entity.Student;
import com.example.SpringBootRestApi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Create
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student studentRes = studentService.create(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentRes);
    }

}
