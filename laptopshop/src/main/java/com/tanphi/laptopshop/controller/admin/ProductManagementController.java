package com.tanphi.laptopshop.controller.admin;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanphi.laptopshop.controller.ApiResponse;
import com.tanphi.laptopshop.request.product.ProductRequest;
import com.tanphi.laptopshop.service.ProductService;

@PreAuthorize("hasAuthority('ADMIN')")
@RestController
@RequestMapping("admin/product")
public class ProductManagementController {
	@Autowired
	private ProductService productService;

	@PostMapping("")
	public ResponseEntity<?> AddNewProduct(@Valid @RequestBody ProductRequest request,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
		}
		productService.AddNewProduct(request);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Thêm sản phẫm thành công");
		return ResponseEntity.ok(apiResponse);
	}

	@PutMapping("/update")
	public ResponseEntity<?> UpdateProduct(@Valid @RequestBody ProductRequest request,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
		}
		productService.UpdateProduct(request);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Cập nhật sản phẫm thành công");
		return ResponseEntity.ok(apiResponse);
	}

	@PutMapping("/delete/{productId}")
	public ResponseEntity<?> DeleteProduct(@PathVariable int productId) {
		productService.DeleteProduct(productId);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Xóa sản phẫm thành công");
		return ResponseEntity.ok(apiResponse);
	}
}
