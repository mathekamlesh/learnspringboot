package com.springboot.learn.service;

import com.springboot.learn.dto.GetCartResponse;
import com.springboot.learn.dto.GetCartProductDetail;
import com.springboot.learn.dto.request.CreateCartRequest;
import com.springboot.learn.dto.request.Request;
import com.springboot.learn.dto.request.UpdateCartRequest;
import com.springboot.learn.entity.Cart;
import com.springboot.learn.entity.CartDetail;
import com.springboot.learn.repository.catalog.CartDetailRepository;
import com.springboot.learn.repository.catalog.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartDetailRepository cartDetailRepository;
    
    public Cart getCartDetail(Long userId){
        PageRequest pageRequest = PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "cartId"));
        Cart cart = cartRepository.findCartByUserId(userId,pageRequest);
        return cart;
    }

    public Cart createCart(Long userId,CreateCartRequest createCartRequest) {
        List<CartDetail> cartDetails = new ArrayList<>();
        createCartRequest.getCartProducts().forEach( cartProduct -> {
            cartDetails.add(new CartDetail().builder()
                    .productId(cartProduct.getProductId())
                    .quantity(cartProduct.getQuantity())
                    .price(cartProduct.getPrice())
                    .build()
            );
        });
        Cart cart = new Cart().builder()
                .userId(userId)
                .type(createCartRequest.getType())
                .addedOn(new Date())
                .updatedOn(new Date())
                .cartDetail(cartDetails)
                .build();
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long userId, UpdateCartRequest updateCartRequest) {
        List<CartDetail> cartDetails = new ArrayList<>();
        updateCartRequest.getCartProducts().forEach( cartProduct -> {
            cartDetails.add(new CartDetail().builder()
                    .productId(cartProduct.getProductId())
                    .quantity(cartProduct.getQuantity())
                    .price(cartProduct.getPrice())
                    .build()
            );
        });
        Cart cart = new Cart().builder()
                .userId(userId)
                .cartId(updateCartRequest.getCartId())
                .type(updateCartRequest.getType())
                .addedOn(new Date())
                .updatedOn(new Date())
                .cartDetail(cartDetails)
                .build();
        return cartRepository.save(cart);
    }
}
