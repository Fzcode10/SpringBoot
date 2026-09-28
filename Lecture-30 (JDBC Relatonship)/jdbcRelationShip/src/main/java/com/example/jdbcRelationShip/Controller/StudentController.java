package com.example.jdbcRelationShip.Controller;

import com.example.jdbcRelationShip.Model.Student;
import com.example.jdbcRelationShip.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }



    @PostMapping("/{deptId}")
    public ResponseEntity<String> createStudent(
            @RequestBody Student student, @PathVariable Long deptId
            ){
        studentService.createStudent(student, deptId);
        return ResponseEntity.ok("Done");
    }

    @PostMapping
    public ResponseEntity<String> createStudent(
            @RequestBody Student student,
            @RequestParam String deptName
    ){
        studentService.createStudent(student, deptName);
        return ResponseEntity.ok("Done");
    }

//    @PostMapping("/withStudent")
//    public ResponseEntity<String> createStudent(
//            @RequestBody Student student,
//            @RequestParam String studentName
//    ){
//        studentService.createStudent(student, studentName);
//        return ResponseEntity.ok("Done");
//    }


}
