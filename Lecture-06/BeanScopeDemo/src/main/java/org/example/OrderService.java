package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class OrderService {

    public OrderService(){
        System.out.println("Order Service created");
    }

    public void order(){
        System.out.println("Order conformed");
    }
}
