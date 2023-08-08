package com.example.order.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;



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

}
