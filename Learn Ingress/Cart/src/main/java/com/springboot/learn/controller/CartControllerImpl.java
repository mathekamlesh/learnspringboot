package com.springboot.learn.controller;

import com.springboot.learn.AppContext;
import com.springboot.learn.datamapper.CartMapper;
import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.response.Response;
import com.springboot.learn.entity.Cart;
import com.springboot.learn.exception.ApiException;
import com.springboot.learn.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Date;

@RestController
public class CartControllerImpl implements CartServiceController {

    private final CartService cartService;
    private final CartMapper cartMapper;
    private final AppContext appContext;

    @Autowired
    public CartControllerImpl(CartService cartService, CartMapper cartMapper, AppContext appContext) {
        this.cartService = cartService;
        this.cartMapper = cartMapper;
        this.appContext = appContext;
    }

    @Override
    public ResponseEntity<Response<GetCartResponse>> getCart(
            @PathVariable(name = "userId",required = false) Long puserId,
            @RequestParam(name = "userId",required = false) Long ruserId) {

        if( puserId == null && ruserId == null ){
            throw new ApiException("0","Please provide userId Cart/getCart/{userId}","0");
        }
        Long userId = puserId == null ? ruserId:puserId;
        Cart cartDetail = cartService.getCartDetail(userId);
        return new ResponseEntity<Response<GetCartResponse>>(cartMapper.createSuccessResponse(cartDetail), HttpStatus.OK);
    }
}
