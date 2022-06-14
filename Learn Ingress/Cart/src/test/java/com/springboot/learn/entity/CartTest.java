package com.springboot.learn.entity;

import com.springboot.learn.repository.catalog.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CartTest {
    @Autowired
    private CartRepository cartRepository;
    @Test
    public void createCart(){
        Cart cart = new Cart().builder()
                .addedOn(new Date())
                .updatedOn(new Date())
                .type(1)
                .userId(1L)
                .cartDetail(List.of(
                        new CartDetail().builder().price(100L).quantity(3L).productId(1234L).build(),
                        new CartDetail().builder().price(300L).quantity(6L).productId(5678L).build()
                ))
                .build();
        cartRepository.save(cart);
    }
    @Test
    public void getCart(){
        PageRequest pageRequest = PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "cartId"));
        Cart cart = cartRepository.findCartByUserId(1L,pageRequest);
        System.out.println(cart);
    }

}