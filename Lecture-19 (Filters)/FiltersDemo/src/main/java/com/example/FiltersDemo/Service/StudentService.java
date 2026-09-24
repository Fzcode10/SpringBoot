package com.example.FiltersDemo.Service;

import com.example.FiltersDemo.dto.Student;
import com.example.FiltersDemo.dto.StudentResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public StudentResponseDto createStudent(Student student){
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMessage("Student is saved successfully");

        return studentResponseDto;
//        try{
//            Thread.sleep(2000);
//        }catch(Exception e){}
    }
}
