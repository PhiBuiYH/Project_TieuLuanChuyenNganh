package com.tanphi.laptopshop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="supplier")
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;
    private Integer supplierName;
    private String image;
    private Integer isDelete;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Product> productSet;
}
