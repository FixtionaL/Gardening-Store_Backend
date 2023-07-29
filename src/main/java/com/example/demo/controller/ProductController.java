package com.example.demo.controller;


import com.example.demo.Models.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping("/addToCart/{productId}")
    public ResponseEntity<String> addToCart(@PathVariable Long productId) {
        productService.addToCart(productId);
        return ResponseEntity.ok("Product added to the cart.");
    }
}
