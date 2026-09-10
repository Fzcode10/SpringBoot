package org.example;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class UserService implements BeanNameAware, ApplicationContextAware {

    public UserService(){
        System.out.println("User constructor called");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
//        System.out.println("ApplicationContext name is "+ applicationContext);
    }

    @Override
    public void setBeanName(String name){  // Spring called itself and you can't use this to set bean name
//        System.out.println("Bean name "+ name);
    }



}
