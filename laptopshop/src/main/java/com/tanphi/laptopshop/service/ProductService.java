package com.tanphi.laptopshop.service;


import com.tanphi.laptopshop.entity.Product;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    List<Product> GetAllProduct(Integer isDeleteStatus);

	Page<Product> getListProductCustomer(Pageable pageable);

	Product getProductById(int id);

	Page<Product> getListProductCustomerByKeyword(Pageable pageable, String keyword);
}
