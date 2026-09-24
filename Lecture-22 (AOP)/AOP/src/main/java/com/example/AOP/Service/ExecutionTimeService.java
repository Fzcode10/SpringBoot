package com.example.AOP.Service;


import com.example.AOP.Entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ExecutionTimeService implements StudentService{

    private LoggingDecorator loggingDecorator;

    public ExecutionTimeService(LoggingDecorator loggingDecorator){
        this.loggingDecorator = loggingDecorator;
    }

    @Override
    public void createStudent(Student student){
        long startTime = System.currentTimeMillis();

        loggingDecorator.createStudent(student);

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken : "+ (endTime-startTime));
    }
}
