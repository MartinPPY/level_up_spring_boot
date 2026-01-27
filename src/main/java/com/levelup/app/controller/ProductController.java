package com.levelup.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.levelup.app.models.Product;
import com.levelup.app.models.dtos.ProductDto;
import com.levelup.app.services.ProductService;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllproduct() {
        return ResponseEntity.ok().body(productService.findAll());
    }
    @PostMapping 
    public ResponseEntity<Product> create(@RequestBody ProductDto productDto){
        System.out.println(productDto.getCode());
        Product newProduct = productService.save(productDto);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(newProduct);
    }

}