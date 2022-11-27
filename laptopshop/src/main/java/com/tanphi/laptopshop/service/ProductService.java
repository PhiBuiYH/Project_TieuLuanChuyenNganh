package com.tanphi.laptopshop.service;


import com.tanphi.laptopshop.entity.Product;
import com.tanphi.laptopshop.request.cart.CartRequest;
import com.tanphi.laptopshop.request.product.ProductRequest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    List<Product> GetAllProduct(Integer isDeleteStatus);

	Page<Product> getListProductCustomer(Pageable pageable);

	Product getProductById(int id);

	Page<Product> getListProductCustomerByKeyword(Pageable pageable, String keyword);

	void AddNewProduct(ProductRequest request);

	void UpdateProduct(ProductRequest request);

	void DeleteProduct(Integer productId);
}
