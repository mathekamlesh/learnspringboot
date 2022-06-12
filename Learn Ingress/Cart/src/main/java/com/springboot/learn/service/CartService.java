package com.springboot.learn.service;

import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.GetCartProductDetail;
import com.springboot.learn.entity.Cart;
import com.springboot.learn.repository.catalog.CartDetailRepository;
import com.springboot.learn.repository.catalog.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartDetailRepository cartDetailRepository;
    
    public Cart getCartDetail(Long userId){
        Cart cart = cartRepository.findCartByUserId(userId);
        return cart;
    }
}
