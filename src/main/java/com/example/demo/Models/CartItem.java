package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String productName;
    private double price;
    private int quantity;

    // Constructors, getters, and setters
    // ...

    public CartItem() {
    	
    }

    public CartItem(User user, Product product, String productName, double price, int quantity) {
        this.user = user;
        this.product = product;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Other constructors, getters, and setters
    // ...

    public String getProductName() {
        return productName;
    }
    
    public Long getProductId() {
        return id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
