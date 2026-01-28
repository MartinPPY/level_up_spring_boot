package com.levelup.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{code}")
    public ResponseEntity<?> getProductById(@PathVariable String code) {
        return ResponseEntity.ok().body(productService.findProductDto(code));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDto productDto) {
        Product newProduct = productService.save(productDto);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(newProduct);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteProduct(@PathVariable String code) {
        Map<String, Object> response = new HashMap<>();

        response.put("message", "Producto eliminado");

        productService.deleteById(code);
        return ResponseEntity.ok().body(response);
    }
}