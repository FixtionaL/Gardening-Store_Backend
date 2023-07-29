package com.example.demo.controller;

import java.security.Principal;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Seller;
import com.example.demo.Models.SellerProduct;
import com.example.demo.Models.User;
import com.example.demo.Repositories.SellerProductRepository;
import com.example.demo.Repositories.SellerRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dto.request.SellerRequest;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("api/v1/auth")
public class SellerController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SellerRepository sellerRepository;
//	@Autowired
//	private SellerProductRepository spRepository;
	
	@PostMapping("/addseller")
	public Seller currentUserName(Principal principal,@RequestBody Seller seller) {
	     	String mail =  principal.getName();

User user = userRepository.findByEmail(mail)

.orElseThrow(() -> new EntityNotFoundException("User with email " + mail + " not found"));

// Associate the contact with the user

System.out.print("herer edsnkjdasbnkjdx");
System.out.println(seller.getPhone_number());
seller.setUser(user);

// Save the contact to the database

return sellerRepository.save(seller);
}
	
//	@PostMapping("/addproducts")
//	public SellerProduct sellProducts(Principal principal,@RequestBody SellerProduct sp)
//	{
////		String mail1 = principal.getName();
////
////User user = userRepository.findByEmail(mail1)
////
////.orElseThrow(() -> new EntityNotFoundException("User with email " + mail1 + " not found"));
////
////Optional<Seller> seller = sellerRepository.findById(user.getId());
////
////	sp.setSeller(seller);
//	return spRepository.save(sp);
//	}
	
}
