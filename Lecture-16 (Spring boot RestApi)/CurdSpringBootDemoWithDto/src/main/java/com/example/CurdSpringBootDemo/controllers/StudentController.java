package com.example.CurdSpringBootDemo.controllers;

import com.example.CurdSpringBootDemo.dto.*;
import com.example.CurdSpringBootDemo.entity.Student;
import com.example.CurdSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
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
    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(
            @Valid @RequestBody CreatStudentRequestDTO creatStudentRequestDTO){

        CreateStudentResponseDTO createdStudent = studentService.createStudent(creatStudentRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    // Read Student
    @GetMapping("/{id}")
    public ResponseEntity<GetStudentResponse> getStudent(@PathVariable Long id){
        GetStudentResponse studentResp = studentService.getStudent(id);

//        if(studentResp == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }

        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }

    @GetMapping
    public ResponseEntity<List<GetStudentResponse>> getAllStudents(){
        List<GetStudentResponse> studentList = studentService.getAllStudent();

//        if(studentList.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }

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
    @PutMapping
    public ResponseEntity<UpdateStuResponseDTO> updateStudentById(@RequestParam Long id, @RequestBody UpdateStuRequestDTO studentReq){

        UpdateStuResponseDTO studentResp = studentService.updateStudent(id, studentReq);

//        if(studentResp == null){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }

        return ResponseEntity.status(HttpStatus.OK).body(studentResp);
    }


    // Delete Student
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);

//        if(isDelete){
//            return ResponseEntity.ok("Record Deleted");
//        }else{
//            return ResponseEntity.notFound().build();
//        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        studentService.deleteStudentSoftly(id);

//        if(!isDeleteSoftly){
//            return ResponseEntity.notFound().build();
//        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
