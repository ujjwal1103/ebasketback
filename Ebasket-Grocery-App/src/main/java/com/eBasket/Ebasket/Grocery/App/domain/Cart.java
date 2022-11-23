package com.eBasket.Ebasket.Grocery.App.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartId", nullable = false)
    private Long id;
    @Column(name = "userId", nullable = false)
    private Long userId;
    @Column(name = "productId", nullable = false)
    private Long productId;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "totalPrice", nullable = false)
    private Long totalPrice;
}
