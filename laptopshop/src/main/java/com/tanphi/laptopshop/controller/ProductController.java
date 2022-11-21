package com.tanphi.laptopshop.controller;

import com.tanphi.laptopshop.entity.enums.IsDeleteStatus;
import com.tanphi.laptopshop.helper.ProductMapper;
import com.tanphi.laptopshop.respone.product.GetProductResponse;
import com.tanphi.laptopshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("hasAuthority('CUSTOMER')")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<Object> GetAllProduct() {
        List<GetProductResponse> listAllProduct= ProductMapper.toResponeGetAllProduct(productService.GetAllProduct(IsDeleteStatus.NO.getCode()));
        return ResponseEntity.ok(listAllProduct);
    }
}
