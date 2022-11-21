package com.tanphi.laptopshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private Integer quantity;
    private String image;
    private Integer unitprice;
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
    private String graphicCardMemory;
    private String batteryCapacity;
    private Integer isdeleted;
    private String osSupplied;
    
    
    public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHardDiskCapacity() {
		return hardDiskCapacity;
	}

	public void setHardDiskCapacity(String hardDiskCapacity) {
		this.hardDiskCapacity = hardDiskCapacity;
	}

	public String getHardDiskType() {
		return hardDiskType;
	}

	public void setHardDiskType(String hardDiskType) {
		this.hardDiskType = hardDiskType;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getScreenResolution() {
		return screenResolution;
	}

	public void setScreenResolution(String screenResolution) {
		this.screenResolution = screenResolution;
	}

	public String getGraphicCardName() {
		return graphicCardName;
	}

	public void setGraphicCardName(String graphicCardName) {
		this.graphicCardName = graphicCardName;
	}

	public String getGraphicCardMemory() {
		return graphicCardMemory;
	}

	public void setGraphicCardMemory(String graphicCardMemory) {
		this.graphicCardMemory = graphicCardMemory;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}


	public String getOsSupplied() {
		return osSupplied;
	}

	public void setOsSupplied(String osSupplied) {
		this.osSupplied = osSupplied;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Integer getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}

	public Set<Cart> getCartSet() {
		return cartSet;
	}

	public void setCartSet(Set<Cart> cartSet) {
		this.cartSet = cartSet;
	}

	public Set<OrderDetail> getOrderDetailSet() {
		return orderDetailSet;
	}

	public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
		this.orderDetailSet = orderDetailSet;
	}

	public Set<Reviews> getReviewsSet() {
		return reviewsSet;
	}

	public void setReviewsSet(Set<Reviews> reviewsSet) {
		this.reviewsSet = reviewsSet;
	}

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
