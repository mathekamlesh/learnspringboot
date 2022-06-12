package com.springboot.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart_detail",schema = "catalog")
public class CartDetail implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cart_detail_id")
    private Long cartDetailId;
    @Column(name = "cart_id")
    private Long cartId;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "price")
    private Long price;
}
