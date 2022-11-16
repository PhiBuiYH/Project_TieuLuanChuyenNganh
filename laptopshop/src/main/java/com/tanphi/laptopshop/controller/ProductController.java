package com.tanphi.laptopshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasAuthority('CUSTOMER')")
@RestController
@RequestMapping("/product")
public class ProductController {
    @GetMapping("")
    public ResponseEntity<?> productCustomer() {
        return ResponseEntity.ok("Product");
    }
}
