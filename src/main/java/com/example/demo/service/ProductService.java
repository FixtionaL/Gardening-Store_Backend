package com.example.demo.service;


import com.example.demo.Models.CartItem;
import com.example.demo.Models.Product;
import com.example.demo.Repositories.CartItemRepository;
import com.example.demo.Repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional
    public void addToCart(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            // Assuming user_id is 16 as per your previous data
            CartItem cartItem = new CartItem();
            cartItemRepository.save(cartItem);
        }
    }
}
