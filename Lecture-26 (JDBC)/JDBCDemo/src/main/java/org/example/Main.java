package org.example;

import org.example.Model.Student;
import org.example.Repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        StudentRepository studentRepository = new StudentRepository();

        Student student = new Student();
        student.setName("Farhan Alam");
        student.setEmail("fade@43wdasasqw3");
        student.setAge(24);

//        studentRepository.createUser(student);

//        studentRepository.updateUser(student, 1);

//        studentRepository.deleteUser(1);

//        studentRepository.getUserById(1);

        studentRepository.getStudents();
    }
}
