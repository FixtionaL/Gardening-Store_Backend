package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.CartItem;
import com.example.demo.Repositories.CartItemRepository;

import java.util.List;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    // Other methods and dependencies

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    public List<CartItem> getCartItemsByUserId(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }
}

