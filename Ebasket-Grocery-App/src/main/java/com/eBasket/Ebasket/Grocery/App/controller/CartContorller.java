package com.eBasket.Ebasket.Grocery.App.controller;

import com.eBasket.Ebasket.Grocery.App.domain.Cart;

import com.eBasket.Ebasket.Grocery.App.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class CartContorller {

    @Autowired
    private final CartService cartService;


    @GetMapping("/cartItemsByUserId/{userId}")
    public Set<Cart> cartItemsByUserId(@PathVariable("userId") Long userId){
        return cartService.cartItemsbyUserId(userId);
    }

    @GetMapping("/cartItemsByUserId/{userId}/{productId}")
    public Optional<Cart> cartItemByUserId(@PathVariable("userId") Long userId, @PathVariable("userId") Long productId){
        return cartService.cartItemByUserId(userId,productId);
    }
    @DeleteMapping("/item/{cartId}")
    public ResponseEntity<HttpStatus> deleteItemById(@PathVariable("cartId") long cartId) {
        try {
            cartService.deleteItemById(cartId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/edit/{cartId}")
    public void updateCart(@PathVariable("id") Long id,@RequestBody Cart cart){
        cartService.updateCart(id,cart);
    }


    @DeleteMapping("/cart/delete/{userId}")
    public void deleteAllByUserId(@PathVariable("userId") Long userId){
        cartService.deleteAllByUserId(userId);
    }

    @PostMapping("/addtoCart")
    public void addToCart(@RequestBody Cart cart) {
        cartService.addToCart(cart);
    }




}
