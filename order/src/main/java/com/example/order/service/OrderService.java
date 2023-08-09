package com.example.order.service;

import com.example.order.entity.OrderEntity;
import com.example.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository repository;

    public List<OrderEntity> getOrderList(final String email){
        return repository.findAllByOrderEmail(email);
    }
    public OrderEntity createOrder(OrderEntity orderEntity) {

        OrderEntity order = OrderEntity.builder()
                .orderEmail(orderEntity.getOrderEmail())
                .orderLocation(orderEntity.getOrderLocation())
                .orderAdult(orderEntity.getOrderAdult())
                .orderChild(orderEntity.getOrderChild())
                .startedAt(orderEntity.getStartedAt())
                .endedAt(orderEntity.getEndedAt())
                .content(orderEntity.getContent())
                .createDate(orderEntity.getCreateDate())
                .modifiedDate(orderEntity.getModifiedDate())
                .startedAt(orderEntity.getOrderStatus())
                .build();

        log.info("request DTO : " + orderEntity.toString());
        return repository.save(order);

    }

    public OrderEntity getOrderDetail(String orderId) {
        return repository.findAllByOrderId(orderId);
    }
}
