package com.tanphi.laptopshop.service;


import com.tanphi.laptopshop.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> GetAllProduct(Integer isDeleteStatus);
}
