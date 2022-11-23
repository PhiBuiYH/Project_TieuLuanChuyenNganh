package com.tanphi.laptopshop.service;

import com.tanphi.laptopshop.entity.Product;
import com.tanphi.laptopshop.entity.enums.IsDeleteStatus;
import com.tanphi.laptopshop.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	@Override
	public Page<Product> getListProductCustomer(Pageable pageable) {
		// TODO Auto-generated method stub
		return productRepo.findProductByIsdeleted(IsDeleteStatus.NO.getCode(), pageable);
	}
	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productRepo.findProductByProductIdAndIsdeleted(id, IsDeleteStatus.NO.getCode());
	}
	@Override
	public Page<Product> getListProductCustomerByKeyword(Pageable pageable, String keyword) {
		// TODO Auto-generated method stub
		return productRepo.findByProductNameContainingAndIsdeleted(keyword, IsDeleteStatus.NO.getCode(), pageable);
	}
}
