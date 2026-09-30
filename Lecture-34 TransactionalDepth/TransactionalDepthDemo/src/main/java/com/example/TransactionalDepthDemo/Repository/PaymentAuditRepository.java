package com.example.TransactionalDepthDemo.Repository;

import com.example.TransactionalDepthDemo.Entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository extends JpaRepository<PaymentAudit , Long> {
}
