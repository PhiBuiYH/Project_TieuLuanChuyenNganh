package com.tanphi.laptopshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanphi.laptopshop.entity.Cart;
import com.tanphi.laptopshop.exception.BadRequestException;
import com.tanphi.laptopshop.mapper.CartMapper;
import com.tanphi.laptopshop.request.cart.CartRequest;
import com.tanphi.laptopshop.service.CartService;

@PreAuthorize("hasAuthority('CUSTOMER')")
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@GetMapping("/{customerId}")
    public ResponseEntity<?> getListCartByCustomer(@PathVariable int customerId)
    {
		List<Cart> listCarts=cartService.getListCartByCustomer(customerId);
		if(listCarts==null || listCarts.size()==0)
		{
			throw new BadRequestException("Giỏ hàng trống");
		}
		return ResponseEntity.ok(CartMapper.toResponeGetAllCartByCustomer(listCarts));
    }

    @PostMapping("")
    public ResponseEntity<?> addToCart(@Valid @RequestBody CartRequest cartRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        cartService.addToCart(cartRequest);
        return ResponseEntity.ok("Thêm giỏ hàng thành công");
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateCart(@Valid @RequestBody CartRequest cartRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        cartService.updateCart(cartRequest);
        return ResponseEntity.ok("Cập nhật giỏ hàng thành công");
    }
    @PutMapping("/delete")
    public ResponseEntity<?> deleteCart(@Valid @RequestBody CartRequest cartRequest, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        cartService.deleteCart(cartRequest);
        return new ResponseEntity<>("Xóa giỏ hàng thành công",HttpStatus.OK);
    }
}
