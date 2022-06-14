package com.springboot.learn.controller;

import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.request.CreateCartRequest;
import com.springboot.learn.dto.request.Request;
import com.springboot.learn.dto.request.UpdateCartRequest;
import com.springboot.learn.dto.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Cart")
public interface CartServiceController {
    @GetMapping(value = {"/{userId}","/getCart"})
    ResponseEntity<Response<GetCartResponse>> getCart(@PathVariable(name = "userId",required = false) Long puserId,
                                                      @RequestParam(name = "userId",required = false) Long ruserId) ;
    @PostMapping(value = {"/{userId}"})
    ResponseEntity<Response<GetCartResponse>> createCart(@PathVariable(name = "userId") Long userId,@RequestBody Request<CreateCartRequest> createCartRequest) ;

    @PutMapping(value = {"/{userId}"})
    ResponseEntity<Response<GetCartResponse>> updateCart(@PathVariable(name = "userId") Long userId,@RequestBody Request<UpdateCartRequest> updateCartRequestRequest) ;
}
