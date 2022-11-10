package com.tanphi.laptopshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.tanphi.laptopshop.exception.BadRequestException;
import com.tanphi.laptopshop.exception.NotFoundException;
import com.tanphi.laptopshop.request.register.RegistrationRequest;
import com.tanphi.laptopshop.service.AuthenticationMapper;

import javax.validation.Valid;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired
    private AuthenticationMapper authenticationMapper;
    @PostMapping("")
    public ResponseEntity<?> registration(@Valid @RequestBody RegistrationRequest request, BindingResult bindingResult)
    {
        if(request.getPassword() != null &&!(request.getPassword().equals(request.getRepassword())))
        {
            throw new BadRequestException("Mật khẩu không ăn khớp");
        }
        if(bindingResult.hasErrors())
        {
            return new ResponseEntity<>(bindingResult.getAllErrors(),HttpStatus.NOT_ACCEPTABLE);
        }
        authenticationMapper.registerUser(request);
        return ResponseEntity.ok("Vui lòng kiểm tra email để hoàn tất quá trình đăng kí.");
    }
    @GetMapping("/activate/{code}")
    public ResponseEntity<String> activateEmailCode(@PathVariable String code) {
        if (!authenticationMapper.activateUser(code)) {
            throw new NotFoundException("Mã code không hợp lệ");
        } else {
            return ResponseEntity.ok("Tài khoản của bạn đã kích hoạt thành công.");
        }
    }
}
