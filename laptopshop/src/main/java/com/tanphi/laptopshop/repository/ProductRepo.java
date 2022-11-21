package com.tanphi.laptopshop.repository;

import com.tanphi.laptopshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> findProductByIsdeleted(Integer status);
}
