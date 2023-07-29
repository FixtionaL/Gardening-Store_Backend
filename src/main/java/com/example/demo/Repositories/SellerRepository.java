package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.Seller;

public interface SellerRepository extends JpaRepository<Seller,Long> {
	
}
