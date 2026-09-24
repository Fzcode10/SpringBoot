package com.example.AOP.Service;

import com.example.AOP.Entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService{

    private StudentServiceImpl studentServiceImp;

    public LoggingDecorator(StudentServiceImpl studentServiceImp){
        this.studentServiceImp = studentServiceImp;
    }

    @Override
    public void createStudent(Student student){
        // Logging related logic

        LoggingServiceUtil.logStart(
                "StudentServiceImpl", "createStudent");

        studentServiceImp.createStudent(student);

        LoggingServiceUtil.logEnd("StudentServiceImpl", "createStudent");
    }
}
