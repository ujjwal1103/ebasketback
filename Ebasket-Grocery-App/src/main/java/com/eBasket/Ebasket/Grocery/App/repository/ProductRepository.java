package com.eBasket.Ebasket.Grocery.App.repository;

import com.eBasket.Ebasket.Grocery.App.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory(String category);


    List<Product> getProductsByTitle(String title);

    Optional<Product> findByTitle(String title);
}
