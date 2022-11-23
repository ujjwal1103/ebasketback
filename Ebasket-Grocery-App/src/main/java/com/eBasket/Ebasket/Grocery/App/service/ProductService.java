package com.eBasket.Ebasket.Grocery.App.service;

import com.eBasket.Ebasket.Grocery.App.domain.Product;
import com.eBasket.Ebasket.Grocery.App.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by sahan on 4/8/2016.
 */
@Service
@Transactional
public class ProductService{

    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        Optional<Product> productTitle = productRepository.findByTitle(product.getTitle());
        if(productTitle.isPresent()){
            throw new IllegalStateException("product is already in a cart");
        }
            return productRepository.save(product);

    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public void updateProduct(Long id, Product newProduct) {
        productRepository.findById(id)
                .map(product -> {
                    product.setTitle(newProduct.getTitle());
                    product.setPrice(newProduct.getPrice());
                    product.setDescription(newProduct.getDescription());
                    product.setQuantity(newProduct.getQuantity());
                    product.setUnit(newProduct.getUnit());
                    product.setCategory(newProduct.getCategory());
                    product.setImage(newProduct.getImage());
                    return productRepository.save(product);
                }).orElseThrow(()->new IllegalStateException("id not found "+ id));
    }

    public void deleteTutorial(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    public List<Product> getAllProductsByTitle(String title) {
        return productRepository.getProductsByTitle(title);
    }

    public static class CartService {
    }
}
