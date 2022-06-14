package com.springboot.learn.repository.catalog;

import com.springboot.learn.entity.Cart;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findCartByUserId(Long userId, PageRequest page);
}
