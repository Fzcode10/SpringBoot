package com.example.TransactionalDepthDemo.Repository;

import com.example.TransactionalDepthDemo.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
