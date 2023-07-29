package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
@CrossOrigin
public class DemoController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello! Harsh");
    }
    
    @Autowired
	RestTemplate rest;
    
    @Autowired
    UserRepository repo;
    
    @PostMapping("/send")
    public ResponseEntity<String> sendDataToServerA(@RequestBody String data) {
        // Prepare the data to be sent to Server A
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(data, headers);

        // Replace "http://localhost:8081/api/send-data" with the actual URL of Server A's endpoint
        String serverAResponse = rest.postForObject("http://localhost:8081/send-data", request, String.class);

        return ResponseEntity.ok("Data sent to Server A. Response from Server A: " + serverAResponse);
    }
    
    
    @GetMapping("/get/{id}")
    public Optional<User> getname(@PathVariable String id)
    {
    		return repo.findByEmail(id);
    	
    }
}