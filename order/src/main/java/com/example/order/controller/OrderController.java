package com.example.order.controller;

import com.example.order.dto.OrderDTO;
import com.example.order.dto.ResponseDTO;
import com.example.order.entity.OrderEntity;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping(path = "")
    public List<?> gerOrderAll(){
        List<OrderEntity> orderListAll = orderService.getOrderListAll();
        log.info("orderListAll : " + orderListAll);

        return orderListAll;

    }

    @GetMapping(path = "", params = "email")
    public List<?> getOrder(@RequestParam(required = true) String email) {
        List<OrderEntity> orderEntity = orderService.getOrderList(email);
        log.info("email param : " + email);
        log.info("orderEntity :" + orderEntity.toString() );
        return orderEntity;
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<OrderEntity> getOrderDetail(@PathVariable(required = true) String orderId) {
        OrderEntity orderDetail = orderService.getOrderDetail(orderId);

        return ResponseEntity.ok().body(orderDetail);
    }

    @PutMapping(path = "/{orderId}")
    public ResponseEntity<OrderEntity> updateOrderStatus(@PathVariable(required = true) String orderId){
        log.info("order status update : orderid = " + orderId);
        OrderEntity orderEntity = orderService.updateOrderStatus(orderId);
        return ResponseEntity.ok().body(orderEntity);

    }


    @PostMapping("/")
    public ResponseEntity<?> createOrder(
            @RequestBody OrderDTO orderDTO
    ) {
        try {
            OrderEntity order = OrderEntity.builder()
                    .orderEmail(orderDTO.getOrderEmail())
                    .orderLocation(orderDTO.getOrderLocation())
                    .orderAdult(orderDTO.getOrderAdult())
                    .orderChild(orderDTO.getOrderChild())
                    .startedAt(orderDTO.getStartedAt())
                    .endedAt(orderDTO.getEndedAt())
                    .content(orderDTO.getOrderContent())
                    .build();

            orderService.createOrder(order);
            return ResponseEntity.ok().body(orderDTO);
        } catch (Exception e) {
            ResponseDTO<Object> responseDTO =
                    ResponseDTO
                            .builder()
                            .error(e.getMessage())
                            .build();

            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }
}
