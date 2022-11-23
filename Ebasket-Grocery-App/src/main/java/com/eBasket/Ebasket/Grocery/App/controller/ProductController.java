package com.eBasket.Ebasket.Grocery.App.controller;


import com.eBasket.Ebasket.Grocery.App.domain.Product;
import com.eBasket.Ebasket.Grocery.App.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(@RequestParam(required = false) String title){
        if(title  != null) {
            return productService.getAllProductsByTitle(title);
        }
        else{
           return productService.getAllProducts();
        }
    }


    @GetMapping("/product/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id){
        return productService.getProduct(id);
    }


    @GetMapping("/product/productbycategory/{category}")
    public List<Product> getProductByCategory(@PathVariable("category") String category){
        return productService.getProductByCategory(category);
    }
    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
       return productService.addProduct(product);
    }

    @PutMapping("/product/edit/{id}")
    public void updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        productService.updateProduct(id,product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            productService.deleteTutorial(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
