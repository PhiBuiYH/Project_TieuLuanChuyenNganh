package com.tanphi.laptopshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @Column(columnDefinition = "Date")
    private Timestamp orderDate;
    @Column(columnDefinition = "Date")
    private Timestamp receptDate;
    private String totalAmount;
    private String shipping;
    private String customerNote;
    private String status;

    @ManyToOne
    @JoinColumn (name = "accountId", nullable = false,referencedColumnName = "accountId")
    @JsonBackReference
    private Accounts account;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<OrderDetail> orderDetailSet;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Reviews> reviewsSet;
}
