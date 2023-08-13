package com.example.seller.client;

import com.example.seller.vo.ResponseOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "order-service", url = "${order_service.url}")
public interface OrderServiceClient {

    @PutMapping("/order/{orderId}")
    List<ResponseOrder> updateOrderStatus(@PathVariable String orderId);
}
