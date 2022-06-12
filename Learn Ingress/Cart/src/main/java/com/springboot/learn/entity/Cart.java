package com.springboot.learn.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart",schema = "catalog")
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "added_on")
    private Date addedOn;
    @Column(name = "updated_on")
    private Date updatedOn;
    @Column(name = "status")
    private Integer status;
    @Column(name = "type")
    private Integer type;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "cart_id",
            referencedColumnName = "cart_id"
    )
    private List<CartDetail> cartDetail;
}
