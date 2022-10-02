package com.tanphi.laptopshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="cart")
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    private Integer quantity;
    private Integer isDelete;

    @ManyToOne
    @JoinColumn (name = "accountId", nullable = false,referencedColumnName = "accountId")
    @JsonBackReference
    private Accounts account;

    @ManyToOne
    @JoinColumn (name = "productId", nullable = false,referencedColumnName = "productId")
    @JsonBackReference
    private Product product;
}
