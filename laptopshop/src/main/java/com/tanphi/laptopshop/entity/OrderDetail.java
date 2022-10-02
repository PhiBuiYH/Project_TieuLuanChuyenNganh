package com.tanphi.laptopshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="orderdetail")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailId;
    private Integer quantity;
    private Integer isDelete;

    @ManyToOne
    @JoinColumn (name = "orderId", nullable = false,referencedColumnName = "orderId",insertable=false, updatable=false)
    @JsonBackReference
    private Orders order;

    @ManyToOne
    @JoinColumn (name = "productId", nullable = false,referencedColumnName = "productId",insertable=false, updatable=false)
    @JsonBackReference
    private Product product;
}
