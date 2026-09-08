package org.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class OrderService {

    PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService){
        this.paymentService = paymentService;
        System.out.println("OrderService created");
    }

    public void orderPlace(){
        paymentService.pay();
        System.out.println("Oder completed");
    }
}
