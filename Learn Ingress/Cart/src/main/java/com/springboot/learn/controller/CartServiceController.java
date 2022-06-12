package com.springboot.learn.controller;

import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Cart")
public interface CartServiceController {
    @GetMapping("/getCart")
    ResponseEntity<Response<GetCartResponse>> getCart();
}
