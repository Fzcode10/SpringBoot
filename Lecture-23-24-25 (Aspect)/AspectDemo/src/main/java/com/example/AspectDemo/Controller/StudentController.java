package com.example.AspectDemo.Controller;

import com.example.AspectDemo.DTO.StudentDto;
import com.example.AspectDemo.Entity.Student;
import com.example.AspectDemo.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody Student student){
        StudentDto s = studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }

    @PostMapping("/all")
    public ResponseEntity<StudentDto> dummyMethod(@RequestBody Student student){
        StudentDto s = studentService.dummyMethod(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/all")
    public ResponseEntity<String> getStudent(){
        String s = " ";
        return ResponseEntity.ok(studentService.getStudent(s));
    }
}
