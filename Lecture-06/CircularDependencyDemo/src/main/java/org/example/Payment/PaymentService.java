package org.example.Payment;

import org.example.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

//    @Autowired
//    private OrderService orderService;

//    public PaymentService(OrderService orderService){
//        this.orderService = orderService;
//    }

    public void pay(){
        System.out.println("Payment done");

        // Payment should not be depended on order service Bean
//        orderService.getOrderDetails();
    }
}
