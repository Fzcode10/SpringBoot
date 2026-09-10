package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Lazy
public class CardService /*implements DisposableBean*/
        /*implements InitializingBean*/ {

    Map<Integer, String> mp ;

    public CardService(){
        mp = new HashMap<>();
        System.out.println("CardService constructor created");
    }

//    @Override
//    public void afterPropertiesSet(){
//        System.out.println("Initialization callBack");
//        mp.put(1, "Faiz");
//        mp.put(2, "Rehan");
//    }


    // Method to use with AppConfig with initMethod = "start" function
    public void start(){
        System.out.println("Initialization callBack");
        mp.put(1, "Faiz");
        mp.put(2, "Rehan");
    }

    // We can do this with constructor but at time of creating of constructor the IOC container have not enough details
    @PostConstruct
    public void start2(){
        System.out.println("Initialization callBack");
        mp.put(1, "Faiz");
        mp.put(2, "Rehan");
    }

    public void getCard(int key){
        System.out.println("for key = "+key+", Value ="+mp.get(key));
    }

    public void addToCard(){
        System.out.println("Item added to card");
    }

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("Bean is getting destroyed");
//    }
//
//    public void stop(){
//        System.out.println("Bean Destroyed");
//    }

    @PreDestroy
    public void stop2(){
        mp.clear();
        System.out.println("Bean Destroyed");
    }
}
