package com.example.twotablehibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customers customerId;
    @Column(nullable = false, length = 30)
    private String productName;
    @Column(nullable = false, precision = 6)
    private int value;
}
