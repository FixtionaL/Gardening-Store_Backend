package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.SellerProduct;

public interface SellerProductRepository extends JpaRepository<SellerProduct,Long> {

}
