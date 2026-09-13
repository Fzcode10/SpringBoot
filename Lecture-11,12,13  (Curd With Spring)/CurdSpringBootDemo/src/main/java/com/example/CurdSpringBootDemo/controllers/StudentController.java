package com.example.CurdSpringBootDemo.controllers;

import com.example.CurdSpringBootDemo.entity.Student;
import com.example.CurdSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Create student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        student.setDeleted(false);
        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // Read Student
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.getAllStudent();

        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }

    @GetMapping("/getAllStu-With-soft-deleted")
    public ResponseEntity<List<Student>> getAllStudentsWithSoftlyDeleted(){
        List<Student> studentList = studentService.getAllStudentWithSoftlyDeleted();

        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }


    // Update Student
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudentById(@RequestParam Long id, @RequestBody Student studentReq){
        Student studentResp = studentService.updateStudent(id, studentReq);

        if(studentResp == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }


    // Delete Student
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        Boolean isDelete = studentService.deleteStudent(id);

        if(isDelete){
            return ResponseEntity.ok("Record Deleted");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        Boolean isDeleteSoftly = studentService.deleteStudentSoftly(id);

        if(!isDeleteSoftly){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Softly deleted");
    }

}
