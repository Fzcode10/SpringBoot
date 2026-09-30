package com.example.TransactionalDepthDemo.Service;

import com.example.TransactionalDepthDemo.Entity.Order;
import com.example.TransactionalDepthDemo.Entity.PaymentAudit;
import com.example.TransactionalDepthDemo.Repository.PaymentAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {

    PaymentAuditRepository paymentAuditRepository;

    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository){
        this.paymentAuditRepository = paymentAuditRepository;
    }


    @Transactional(
//            propagation = Propagation.REQUIRED
//            propagation = Propagation.REQUIRES_NEW  // New Transaction start
//            propagation = Propagation.SUPPORTS   // Best for helper function as parent function
            propagation = Propagation.MANDATORY,
            isolation = Isolation.REPEATABLE_READ
    )
    public void audit(Order order){
        PaymentAudit paymentAudit  =
                new PaymentAudit(order.getAmount(), order.getId(), true);

        paymentAuditRepository.save(paymentAudit);

        throw new RuntimeException("Some Error Occurred");

//        try{
//            System.out.println("Error");
//            throw new RuntimeException("Some Error Occurred");
//        }catch(RuntimeException e){
//
//        }
    }
}
