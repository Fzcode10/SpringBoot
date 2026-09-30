package com.example.TransactionalDepthDemo.Service;


import com.example.TransactionalDepthDemo.Entity.Order;
import com.example.TransactionalDepthDemo.Repository.OrderRepository;
import com.example.TransactionalDepthDemo.Repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    OrderRepository orderRepository;
    PaymentAuditService paymentAuditService;

    public OrderService(
            OrderRepository orderRepository,
            PaymentAuditService paymentAuditService
    ){
        this.orderRepository = orderRepository;
        this.paymentAuditService = paymentAuditService;
    }

    @Transactional(

    )
    public void placeOrder(Order order){
        orderRepository.save(order);


//        throw new RuntimeException("Some Error Occurred");

        try{
            paymentAuditService.audit(order);
        }catch(RuntimeException e){

        }
    }

}
