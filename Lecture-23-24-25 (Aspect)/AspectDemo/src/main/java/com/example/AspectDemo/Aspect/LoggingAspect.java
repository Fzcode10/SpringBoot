package com.example.AspectDemo.Aspect;

import com.example.AspectDemo.Annotation.TrackExecutionTime;
import com.example.AspectDemo.DTO.StudentDto;
import com.example.AspectDemo.Entity.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // Day 1

//    @Before("execution(String com.example.AspectDemo.Service.StudentService.create())")
//    public void logBeforeMethod(JoinPoint joinPoint){
//
//        Object[] arr = joinPoint.getArgs();
//
//        System.out.println("Student is going to be saved");


//        boolean allowed = false;
//
//        if(!allowed){
//            throw new RuntimeException("Method Execution not allowed");
//        }

//    }

//
//    @AfterReturning(
//            value = "execution(* com.example.AspectDemo.Service.StudentService.create(..))",
//            returning = "result")
//    public void logAfterReturnMethod(StudentDto result){
//
//        System.out.println("Log after method called");
//
//        result.setName("Rehan");
//
//        System.out.println("Target Method returned : "+ result);
//    }

//    @AfterThrowing(
//            value = "execution(* com.example.AspectDemo.Service.StudentService.create(..))",
//            throwing = "exception")
//    public void logAfterThrowingMethod(Throwable exception){
//        System.out.println("Exception type : "+exception.getClass().getName());
//        System.out.println("Exception message : "+exception.getMessage());
//
//
//    }

//    @After(
//            value = "execution(* com.example.AspectDemo.Service.StudentService.create(..))")
//    public void logAfterMethod(){
//        System.out.println("Log after method");
//    }

//    @Around(
//            value = "execution(* com.example.AspectDemo.Service.StudentService.create(..))")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Starting : "+joinPoint.getSignature().getName());
//
//        try{
//            Object result = joinPoint.proceed();
//
//            System.out.println("Execution Successful");
//
//            return result;
//
//        }catch(Exception e){
//            System.out.println("Execution Failed");
//            throw e;
//        }finally {
//            System.out.println("Execution completed");
//        }
//    }
//
//
//    @Around(
//            value = "execution(* com.example.AspectDemo.Service.StudentService.dummyMethod(..))")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

//        Object[] arr = joinPoint.getArgs();
//
//        String originalString  = (String) arr[0];
//
//        String modifiedString = originalString.toUpperCase();
//
//        Object[] modifiedArr = {
//                modifiedString
//        };
//
//        String returnType = (String) joinPoint.proceed(modifiedArr);
//
//        returnType = returnType +": String Intercepted";
//
//        return returnType;

//        Object retunr1  = joinPoint.proceed();
//
//        System.out.println("Intercepted request calling again");
//
//        Object return2 = joinPoint.proceed();
//
//        return return2;
//    }





    // Day 2

    //    @Before("execution(* com.example.AspectDemo.Service..* (..))")
//    public void lagBeforeMethod(){
//        System.out.println("Method Intercepted");
//        System.out.println("Service Method");
//    }
//
//    @Before("within(com.example.AspectDemo.Service..*)")
//    public void lagBeforeMethod(){
//        System.out.println("Method Intercepted");
//        System.out.println("Service Method");
//    }
//
//
//    @Before("bean(studentService) || bean(studentController)")
//    public void lagBeforeMethod(){
//        System.out.println("Method Intercepted");
//        System.out.println("Service Method");
//    }
//
//
    // Name pointcut completed within ApplicationPointsAspect
//    @Pointcut("within(com.example.AspectDemo.Service..*) " +
//            "&&" +
//            "execution(public * * (..))")
//    public void lagPublicServiceMethod(){
//        // Empty Method
//    }
//
//    @Before("com.example.AspectDemo.Aspect.ApplicationPointcuts.serviceLayer()")
//    public void lagBeforeMethod(){
//        System.out.println("Method Intercepted");
//        System.out.println("Service Method");
//    }
//
//    @After("com.example.AspectDemo.Aspect.ApplicationPointcuts.publicServiceMethod()")
//    public void logAfterMethod(){
//        System.out.println("Method after call");
//    }
//
//    @Around("lagPublicServiceMethod()")
//    public void logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Method around before call");
//        joinPoint.proceed();
//        System.out.println("Method around after call");
//    }
//
//
//    @Pointcut("within(com.example.AspectDemo.Service..*)")
//    public void serviceLayer(){
//
//    }
//
//    @Before("com.example.AspectDemo.Aspect.ApplicationPointcuts.serviceLayer()")
//    public void logBeforeMethod() {
//        System.out.println("Method Intercepted");
//        System.out.println("Service Method");
//    }
//
//
    //    @Around("@annotation(jdk.jfr.Timestamp")
//    public void evaluateTimeMethod(ProceedingJoinPoint joinPoint){
//        long startTime = System.currentTimeMillis();
//
//        joinPoint.proceed();
//
//        long endTime = System.currentTimeMillis();
//
//        System.out.println(endTime-startTime);
//
//    }
//
//
//
    //    @Before("execution(public com.example.AspectDemo.DTO.StudentDto " +
//            "com.example.AspectDemo.Service" +
//            ".StudentService.create(" +
//            "com.example.AspectDemo.Entity.Student))")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }



    // Day 3

//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }
//
//    @Around("@annotation(com.example.AspectDemo.Annotation.TrackExecutionTime)")
//    public Object measureExecutionTime(ProceedingJoinPoint joinPoint)throws Throwable{
//        long startTime = System.currentTimeMillis();
//
//        try{
//            return joinPoint.proceed();
//        }
//        finally {
//            long endTime = System.currentTimeMillis();
//            long totalDuration = endTime-startTime;
//
//            String methodName = joinPoint.getSignature().getName();
//            System.out.println("Time taken by "+methodName+" : "+totalDuration);
//        }
//    }

    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
                                       TrackExecutionTime trackExecutionTime)
            throws Throwable{
        long startTime = System.currentTimeMillis();

        try{
            return joinPoint.proceed();
        }
        finally {
            long endTime = System.currentTimeMillis();
            long totalDuration = endTime-startTime;

            String operation = trackExecutionTime.operation();
            if(operation.isBlank()){
                operation = joinPoint.getSignature().getName();
            }

            long warningThreshold = trackExecutionTime.warnAfter();
            if(totalDuration >= warningThreshold){
                System.out.println("Slow operation ALERT : "+
                        "Time taken by "+
                        operation+" : "+totalDuration);
            }
            else{
                System.out.println(
                    "Time taken by "+operation+" : "+totalDuration);
            }
        }
    }

}
