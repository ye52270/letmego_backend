package com.example.seller.repository;

import com.example.seller.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity, String> {
    SellerEntity findByOrderId(String orderId);
}
