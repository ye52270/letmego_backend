package com.example.order.dto;

import lombok.*;

import java.time.LocalDateTime;

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
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
    private String orderStatus;
}

