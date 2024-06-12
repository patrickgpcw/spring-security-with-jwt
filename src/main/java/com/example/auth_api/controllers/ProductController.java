package com.example.auth_api.controllers;

import com.example.auth_api.domains.product.Product;
import com.example.auth_api.domains.product.ProductRequestDTO;
import com.example.auth_api.domains.product.ProductResponseDTO;
import com.example.auth_api.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @PostMapping
    public ResponseEntity<?> save (@RequestBody @Valid ProductRequestDTO body){
        Product newProduct = new Product(body);

        this.repository.save(newProduct);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<?> showAll (){
        List<ProductResponseDTO> productList = this.repository.findAll().stream().map(ProductResponseDTO::new).toList();
        return ResponseEntity.ok(productList);
    }
}
