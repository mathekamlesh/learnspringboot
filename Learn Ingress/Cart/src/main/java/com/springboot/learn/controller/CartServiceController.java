package com.springboot.learn.controller;

import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/Cart")
public interface CartServiceController {
    @GetMapping(value = {"/getCart/{userId}","/getCart"})
    ResponseEntity<Response<GetCartResponse>> getCart(@PathVariable(name = "userId",required = false) Long puserId,
                                                      @RequestParam(name = "userId",required = false) Long ruserId);
}
