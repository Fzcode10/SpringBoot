package com.example.AspectDemo.Service;

import com.example.AspectDemo.Annotation.TrackExecutionTime;
import com.example.AspectDemo.DTO.StudentDto;
import com.example.AspectDemo.Entity.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentDto createStudent(Student student){
        System.out.println("Student Created");

//        try{
//            throw new RuntimeException("Some error at student service");
//        }catch(RuntimeException e) {}

        StudentDto s = new StudentDto();

        s.setAge(student.getAge());
        s.setName(student.getName());

//        throw new RuntimeException("Some Error occurred at Student service");

        return s;

    }


    @TrackExecutionTime(
            warnAfter = 2000,
            operation = "Dummy Operation"
    )
    public StudentDto dummyMethod(Student s){
        System.out.println("Dummy Method called");
        StudentDto st = new StudentDto();
        st.setName(s.getName());
        st.setAge(s.getAge());
        return st;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Get Student Data"
    )
    public String getStudent(String st){

        try{
            Thread.sleep(2000);
        }catch (Exception e) {}

        String s = "All Student Data";
        System.out.println(s);
        return s;
    }


}
