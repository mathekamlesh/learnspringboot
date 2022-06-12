package com.springboot.learn.controller;

import com.springboot.learn.datamapper.CartMapper;
import com.springboot.learn.dto.response.Body;
import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.response.Header;
import com.springboot.learn.dto.response.Response;
import com.springboot.learn.entity.Cart;
import com.springboot.learn.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartControllerImpl implements CartServiceController {
    @Autowired
    CartService cartService;
    @Autowired
    CartMapper cartMapper;

    @Override
    public ResponseEntity<Response<GetCartResponse>> getCart() {
        Cart cartDetail = cartService.getCartDetail(1L);
        return new ResponseEntity<Response<GetCartResponse>>(cartMapper.createSuccessResponse(cartDetail), HttpStatus.OK);
    }
}
