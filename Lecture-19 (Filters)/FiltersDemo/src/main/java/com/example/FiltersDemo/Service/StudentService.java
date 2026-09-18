package com.example.FiltersDemo.Service;

import com.example.FiltersDemo.dto.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student student){
        System.out.println("Student Created");
        System.out.println(student.getEmail());
        System.out.println(student.getName());

        try{
            Thread.sleep(2000);
        }catch(Exception e){}
    }
}
