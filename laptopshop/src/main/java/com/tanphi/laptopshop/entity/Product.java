package com.tanphi.laptopshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;
    private Integer quantity;
    private String image;
    private Integer unitPrice;
    private Integer discount;
    private String description;
    private String CPU;
    private String ram;
    private String weight;
    private String hardDiskCapacity;
    private String hardDiskType;
    private String screenSize;
    private String screenResolution;
    private String graphicCardName;
    private String graphicCardChipSet;
    private String batteryCapacity;
    private Integer isDelete;
    private String osSupplied;

    @ManyToOne
    @JoinColumn(name = "supplierId", nullable = false,referencedColumnName = "supplierId")
    @JsonBackReference
    private Supplier supplier;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Cart> cartSet;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<OrderDetail> orderDetailSet;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Reviews> reviewsSet;
}
