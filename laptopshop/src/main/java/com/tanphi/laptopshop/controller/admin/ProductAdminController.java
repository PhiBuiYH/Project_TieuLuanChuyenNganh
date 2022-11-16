package com.tanphi.laptopshop.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("admin/product")
public class ProductAdminController {
    @GetMapping("")
    public ResponseEntity<?> productAdmin() {
        return ResponseEntity.ok("Admin Product");
    }
}
