package com.example.seller.dto;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO {
    private String proposalId;
    private String orderId;
    private String orderEmail;
    private String proposalEmail;
    private String orderLocation;
    private String orderAdult;
    private String orderChild;
    private String startedAt;
    private String endedAt;
    private String orderContent;
    private String orderStatus;
    private String proposalAmount;
    private String proposalContent;
    private LocalDateTime createDate;
    private LocalDateTime modifiedDate;
}
