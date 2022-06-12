package com.springboot.learn.repository.catalog;

import com.springboot.learn.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail,Long> {
}
