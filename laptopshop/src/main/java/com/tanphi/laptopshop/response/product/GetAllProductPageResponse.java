package com.tanphi.laptopshop.response.product;

import java.util.List;

public class GetAllProductPageResponse {
	private Integer totalPage;
	private Integer currentPage;
	private List<GetProductResponse> listProducts;
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<GetProductResponse> getListProducts() {
		return listProducts;
	}
	public void setListProducts(List<GetProductResponse> listProducts) {
		this.listProducts = listProducts;
	}
	
}
