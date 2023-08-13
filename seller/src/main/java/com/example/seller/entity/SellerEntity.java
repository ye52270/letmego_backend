package com.example.seller.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@ToString
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proposal")
public class SellerEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String proposalId;

    @Column(name = "orderId")
    private String orderId;

    @Column(name = "order_email")
    private String orderEmail;

    @Column(name = "proposal_email")
    private String proposalEmail;

    @Column(name = "location")
    private String orderLocation;

    @Column(name = "adult")
    private String orderAdult;

    @Column(name = "child")
    private String orderChild;

    @Column(name = "start_date")
    private String startedAt;

    @Column(name = "end_date")
    private String endedAt;

    @Column(name = "order_content")
    private String orderContent;

    @Column(name = "status")
    private String orderStatus;

    @Column(name="proposal_amount")
    private String proposalAmount;

    @Column(name = "proposal_content")
    private String proposalContent;

    @Column(name = "create_date")
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
