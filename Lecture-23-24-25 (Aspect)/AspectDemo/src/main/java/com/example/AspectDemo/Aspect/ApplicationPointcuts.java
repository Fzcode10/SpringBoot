package com.example.AspectDemo.Aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {

    @Pointcut("within(com.example.AspectDemo.Controller..*)")
    public void controllerLayer(){
        // Empty body
    }

    @Pointcut("within(com.example.AspectDemo.Service..*)")
    public void serviceLayer() {
    }

    @Pointcut("execution(public * * (..))")
    public void publicMethod(){
        // Empty body
    }

    @Pointcut("publicMethod() " +
            "&&" +
            "serviceLayer()")
    public void publicServiceMethod(){
        // Empty Body
    }

    @Pointcut("execution(* *.get* (..))")
    public void getStartMethod(){
        // Empty body
    }



}
