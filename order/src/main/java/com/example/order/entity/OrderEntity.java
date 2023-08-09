package com.example.order.entity;

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
@Table(name = "customer_order")
public class OrderEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String orderId;

    @Column(name = "email")
    private String orderEmail;

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

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String orderStatus;

    @Column(name = "create_date")
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
