package com.tanphi.laptopshop.service;

import com.tanphi.laptopshop.entity.Product;
import com.tanphi.laptopshop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> GetAllProduct(Integer isDeleteStatus) {
        return productRepo.findProductByIsdeleted(isDeleteStatus);
    }
}
