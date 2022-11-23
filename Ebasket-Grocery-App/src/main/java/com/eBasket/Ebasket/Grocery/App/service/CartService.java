package com.eBasket.Ebasket.Grocery.App.service;
import com.eBasket.Ebasket.Grocery.App.domain.Cart;
import com.eBasket.Ebasket.Grocery.App.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CartService {
    @Autowired
    private final CartRepository cartRepository;


    public void addToCart(Cart cart) {
       Optional<Cart> UserIDAndProductId = cartRepository.findByUserIdAndProductId(cart.getUserId(),cart.getProductId());
       if(UserIDAndProductId.isPresent()){
           throw new IllegalStateException("Product is already in a cart");
       }
        cartRepository.save(cart);
    }
    public Set<Cart> cartItemsbyUserId(Long userId) {


        return cartRepository.findAllByUserId(userId);
    }
    public void deleteItemById(long cartId) {
        cartRepository.deleteById(cartId);
    }

    public void updateCart(Long id, Cart newCart) {
        cartRepository.findById(id)
                .map(cart -> {
                   cart.setQuantity(newCart.getQuantity());
                   cart.setTotalPrice((newCart.getTotalPrice()));
                    return cartRepository.save(cart);
                }).orElseThrow(()->new IllegalStateException("id not found "+ id));
    }

    public Optional<Cart> cartItemByUserId(Long userId, Long productId) {
        return cartRepository.findByUserIdAndProductId(userId,productId);
    }

    @Transactional
    public void deleteAllByUserId(Long userId) {
       cartRepository.deleteAllByUserId(userId);
    }


}
