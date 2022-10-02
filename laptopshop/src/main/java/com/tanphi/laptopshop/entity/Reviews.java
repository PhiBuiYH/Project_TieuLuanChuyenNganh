package com.tanphi.laptopshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="reviews")
@Data
public class Reviews {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer reviewId;
    private String contents;
    private Double rate;
    @Column(columnDefinition = "Date")
    private Timestamp reviewsDate;

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false,referencedColumnName = "orderId",insertable=false, updatable=false)
    @JsonBackReference
    private Orders order;

    @ManyToOne
    @JoinColumn (name = "productId", nullable = false,referencedColumnName = "productId",insertable=false, updatable=false)
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "accountId",nullable = false,referencedColumnName = "accountId",insertable = false,updatable = false)
    @JsonBackReference
    private Accounts account;
}
