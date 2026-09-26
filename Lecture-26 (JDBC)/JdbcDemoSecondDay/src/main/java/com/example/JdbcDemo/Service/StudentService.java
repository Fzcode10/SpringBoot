package com.example.JdbcDemo.Service;

import com.example.JdbcDemo.model.Student;
import com.example.JdbcDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student) {
        studentRepository.createStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.getStudent();
//        return new ArrayList<>();
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
//        return new Student();
    }

    public void updateStudent(Student student, long id) {
        studentRepository.updateStudent(student, id);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }
}
