package com.eBasket.Ebasket.Grocery.App.repository;

import com.eBasket.Ebasket.Grocery.App.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Set<Cart> findAllByUserId(Long userId);

    Optional<Cart> findByUserIdAndProductId(Long userId, Long productId);


    void deleteAllByUserId(Long userId);


}
