package com.example.SpringBootRestApi.service;

import com.example.SpringBootRestApi.entity.Student;
import com.example.SpringBootRestApi.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student create(Student studentReq){
        Student studentRes = studentRepository.save(studentReq);
        return studentRes;
    }
}
