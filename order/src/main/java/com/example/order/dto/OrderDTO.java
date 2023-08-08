package com.example.order.dto;

import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String orderEmail;
    private String orderLocation;
    private String orderAdult;
    private String orderChild;
    private String startedAt;
    private String endedAt;
    private String orderContent;
}

