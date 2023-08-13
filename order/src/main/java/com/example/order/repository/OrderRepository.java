package com.example.order.repository;

import com.example.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String> {
    List<OrderEntity> findAllByOrderEmail(String email);
    OrderEntity findAllByOrderId(String orderId);

}
