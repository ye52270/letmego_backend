package com.example.seller.vo;

import lombok.Data;

@Data
public class ResponseOrder {
    private String orderId;
    private String orderEmail;
    private String orderLocation;
    private String orderAdult;
    private String orderChild;
    private String startedAt;
    private String endedAt;
    private String content;
    private String orderStatus;
}
