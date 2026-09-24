package com.example.AOP.Repository;

import com.example.AOP.Entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student){
        System.out.println("Student saved");
    }
}
